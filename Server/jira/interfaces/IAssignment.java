package jira.interfaces;

import javax.ejb.Remote;
import javax.ejb.Remove;
import jira.entities.Department;
import jira.entities.Employee;
import jira.exceptions.*;

@Remote
public interface IAssignment {

    public String startSession(int id_department);
    public String assignEmployee(int id_employee)  throws AgeThreshold, LimitEmployees;
    public Department getDep();
}
