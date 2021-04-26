
import jira.entities.*;
import jira.exceptions.AgeThreshold;
import jira.exceptions.LimitEmployees;
import jira.interfaces.*;


import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Client {
// text
    private IDepartmentManagement dptmanagement;
    private IEmployeeManagement empmanagement;
    private IAssignment assign;
    private IInfos infos;


    public static void main(String[] args) throws AgeThreshold, LimitEmployees {

        Client app = new Client();
        app.init();
        System.out.println();

        app.displayEmployees();
        app.displayDepartments();
        System.out.println();
        System.out.println();

        System.out.println("** Create a new employee ** ");
        app.displayEmployees();
        System.out.println();
        app.trycreateemployee(666, 2 , "Theo", "Dupont", 27);
        System.out.println();
        app.displayEmployees();

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();

        System.out.println("** Start Session for Department 4 ** ");
        app.trystartsession(4);

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();


        System.out.println("** Assigning an Employee to Department 4 ** ");
        app.displayEmployees();
        app.displayDepartments();
        System.out.println();
        app.tryassignemployee(555);
        System.out.println();
        app.displayEmployees();
        app.displayDepartments();

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();


        System.out.println("** Create a new department ** ");
        app.displayDepartments();
        System.out.println();
        app.trycreatedepartment(8,"Test", 0, 3);
        System.out.println();
        app.displayDepartments();

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();

        System.out.println("** Remove Department 8 ** ");
        app.displayDepartments();
        System.out.println();
        app.tryremovedepartment(8);
        System.out.println();
        app.displayDepartments();

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();


        /** To comment based on which exception we want to test **/
        /**
        System.out.println("** Test Assign too young people ** ");
        app.displayEmployees();
        app.displayDepartments();
        System.out.println();
        app.tryassignemployee(777);
        System.out.println();
        app.displayEmployees();
        app.displayDepartments();

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();**/

        /** To comment based on which exception we want to test **/
        /**
        System.out.println("** Test Assign too old people ** ");
        app.displayEmployees();
        app.displayDepartments();
        System.out.println();
        app.tryassignemployee(888);
        System.out.println();
        app.displayEmployees();
        app.displayDepartments();

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();**/

        /** To comment based on which exception we want to test **/
        System.out.println("** Test Limit Employee ** ");
        app.displayEmployees();
        app.displayDepartments();
        System.out.println();
        app.tryassignemployee(448);
        System.out.println();
        app.displayEmployees();
        app.displayDepartments();

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();


    }

    private void init(){
        try {
            InitialContext initialContext = new InitialContext();
            dptmanagement = (IDepartmentManagement) initialContext.lookup(IDepartmentManagement.class.getName());
            empmanagement = (IEmployeeManagement) initialContext.lookup(IEmployeeManagement.class.getName());
            assign = (IAssignment) initialContext.lookup(IAssignment.class.getName());
            infos = (IInfos) initialContext.lookup(IInfos.class.getName());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    private void displayEmployees() {
        System.out.println("> List of all employees ");
        infos.displayAllEmployees().forEach(Employee -> System.out.println(Employee.toString()));
    }

    private void displayDepartments() {
        System.out.println("> List of all departments ");
        infos.displayAllDepartment().forEach(Department -> System.out.println(Department.toString()));
    }

    private void trycreateemployee(int id_employee, int id_department, String first_name, String last_name, int age) {
        System.out.println("> Creation Employee ID : " + id_employee);
        empmanagement.createEmployee(id_employee, id_department, first_name, last_name, age);
    }


    private void tryremoveemployee(int id_employee) {
        System.out.println("> Remove Employee ID : " + id_employee);
        empmanagement.removeEmployee(id_employee);
    }

    private void trycreatedepartment(int id_department, String name, int floor, int bat_number) {
        System.out.println("> Create Department ID : " + id_department);
        dptmanagement.createDepartment(id_department, name, floor, bat_number);
    }

    private void tryremovedepartment(int id_department) {
        System.out.println("> Remove Department ID : " + id_department);
        dptmanagement.removeDepartment(id_department);
    }

    private void tryassignemployee(int id_employee) throws LimitEmployees, AgeThreshold {
        System.out.println("> Assign Employee ID : " + id_employee);
        assign.assignEmployee(id_employee);
    }

    private void trystartsession(int id_department){
        assign.startSession(id_department);
    }
}
