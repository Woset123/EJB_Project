package jira.beansessions;

import jira.*;
import jira.entities.Department;
import jira.entities.Employee;
import jira.interfaces.IInfos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class Infos implements IInfos {

    @PersistenceContext(unitName="JIRA_PU")
    protected EntityManager em;

    @Override
    public List<Employee> displayAllEmployees() {
        TypedQuery<Employee> EmployeeList = em.createNamedQuery("displayEmployees", Employee.class);
        return EmployeeList.getResultList();
    }

    @Override
    public List<Department> displayAllDepartment() {
        TypedQuery<Department> DepartmentList = em.createNamedQuery("displayDepartment", Department.class);
        return DepartmentList.getResultList();
    }

    @Override
    public List<Employee> findByDepartment(int id_department) {
        TypedQuery<Employee> findEmp = em.createNamedQuery("displayEmpAssignDep", Employee.class);
        findEmp.setParameter("id_department", id_department);
        return findEmp.getResultList();
    }

}
