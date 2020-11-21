package jira.beansessions;


import javax.ejb.Stateful;
import javax.ejb.Remove;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import jira.entities.*;
import jira.exceptions.AgeThreshold;
import jira.exceptions.LimitEmployees;
import jira.interfaces.*;


@Stateful
public class AssignmentSB implements IAssignment {

    private int AGEMIN;
    private int AGEMAX;
    private int LIMITEMP;

    @PersistenceContext(unitName="JIRA_PU",type=PersistenceContextType.EXTENDED)
    protected EntityManager em;
    protected Department d;




    /**
     * Start a new session and save the id_department
     * @param id_department
     * @return
     */
    public String startSession(int id_department) {
        d = em.find(Department.class, id_department);
        if(d != null) {
            em.persist(d);
            return "Start Session for Department " + d.getName();}
        else
            return "This Department does not exist !";
    }

    /**
     * Assign an existing employee to the active department
     * @param id_employee
     * @return confirmation message
     */
    public String assignEmployee(int id_employee)  throws AgeThreshold, LimitEmployees {
        Employee e = em.find(Employee.class, id_employee);

        if (d != null) {

            /* Reduce nbemployee by 1 for the former department */
            Department dep = em.find(Department.class, e.getId_department());
            dep.setNbemployee(dep.getNbemployee() - 1);
            em.persist(dep);

            /* Assignment */

            e.setId_department(d.getId_department());


            /* Raise nbemployee by 1 for the new department */
            d.setNbemployee(d.getNbemployee() + 1);
            em.persist(d);


            if (e.getAge()< AGEMIN | e.getAge()> AGEMAX) {
                throw new AgeThreshold("Bad Age !");
            }

            if (d.getNbemployee()>LIMITEMP) {
                throw new LimitEmployees("Limit reached !!");
            }
            em.merge(e);
            return "Employee ID : " + id_employee + "has been assigned to Department ID : " + d.getId_department();

        }
        else
            return "Error";
    }

    /**
     * Getter to return the Entity Department saved in the persistance context
     * @return d
     */
    public Department getDep() {
        return this.d;
    }
}
