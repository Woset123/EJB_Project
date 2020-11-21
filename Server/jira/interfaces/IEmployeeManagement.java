package jira.interfaces;

import javax.ejb.Remote;
import java.util.List;
import jira.exceptions.*;

@Remote
public interface IEmployeeManagement {

    public String createEmployee(int id_employee, int id_department, String first_name, String last_name, int age);
    public String removeEmployee(int id_employee);

}