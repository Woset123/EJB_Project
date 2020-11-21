package jira.interfaces;

import javax.ejb.Remote;
import java.util.List;

import jira.entities.Department;
import jira.entities.Employee;
import jira.exceptions.*;

@Remote
public interface IInfos {


    List<Employee> displayAllEmployees();
    List<Department> displayAllDepartment();
    List<Employee> findByDepartment(int id_department);

}