package jira.beansessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jira.entities.*;
import jira.exceptions.AgeThreshold;
import jira.exceptions.LimitEmployees;
import jira.interfaces.*;

import java.util.List;


@Stateless
public class DepartmentSB implements IDepartmentManagement {

    @PersistenceContext(unitName="JIRA_PU")
    protected EntityManager em;
    private IInfos infos;
    private IAssignment assign;

    /**
     * Create a new Department
     * @param id_department
     * @param name
     * @param floor
     * @param bat_number
     * @return confirmation message
     */
    public String createDepartment(int id_department, String name, int floor, int bat_number) {
        Department d1 = new Department(id_department, name, floor, bat_number);
        em.persist(d1);
        return "Department ID : " + id_department + " has been added !";
    }

    /**
     * Remove an existing Department
     * @return confirmation message
     */
    public void removeDepartment(int id_department) {

        /** Not functional -> Raise rmi.exception
        if (assign.getDep()!=null) {
            Department old_dep = em.find(Department.class, assign.getDep().getId_department());


            assign.startSession(0);
            //Unassign all the employees of this department
            infos.findByDepartment(old_dep.getId_department()).forEach(Employee  -> {
                try {
                    assign.assignEmployee(Employee.getId_employee());
                } catch (AgeThreshold ageThreshold) {
                    ageThreshold.printStackTrace();
                } catch (LimitEmployees limitEmployees) {
                    limitEmployees.printStackTrace();
                }
            });

            em.remove(old_dep);
        }**/
        Department dep = em.find(Department.class, id_department);
        em.remove(dep);
    }


}