package jira.beansessions;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import jira.entities.*;
import jira.interfaces.*;


@Stateless
public class EmployeeSB implements IEmployeeManagement {



    @PersistenceContext(unitName="JIRA_PU")
    protected EntityManager em;




    /**
     * Create a new employee
     * @param id_employee
     * @param id_department
     * @param first_name
     * @param last_name
     * @param age
     * @return confirmation message
     */
    public String createEmployee(int id_employee, int id_department, String first_name, String last_name, int age) {
        Employee e = new Employee(id_employee, id_department, first_name, last_name, age);
        em.persist(e);

        Department d = em.find(Department.class, e.getId_department());
        d.setNbemployee(d.getNbemployee() + 1);
        em.persist(d);
        return "Employee ID : " + id_employee + " has been added !";
    }

    /**
     * Remove an existing employee
     * @param id_employee
     * @return confirmation message
     */
    public String removeEmployee(int id_employee) {
        Employee e = em.find(Employee.class, id_employee);

        Department d = em.find(Department.class, e.getId_department());
        d.setNbemployee(d.getNbemployee() -1);

        em.persist(d);
        em.remove(e);
        return "Employee ID : " + id_employee + " has been removed !";
    }


}