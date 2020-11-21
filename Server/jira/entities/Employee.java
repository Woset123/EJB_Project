package jira.entities;


import jira.exceptions.AgeThreshold;
import jira.exceptions.LimitEmployees;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import java.io.Serializable;


@Entity
@Table(name="employee")
@NamedQueries({
        @NamedQuery(name="displayEmployees", query="SELECT e FROM Employee e"),
        @NamedQuery(name="displayEmpAssignDep", query="SELECT e FROM Employee e WHERE e.id_department = :id_department")
})
public class Employee implements Serializable {

    /**
     * Attributes
     */
    @Id
    private int id_employee;
    private int id_department = 0;
    private String first_name;
    private String last_name;
    private int age;


    /**
     * Constructor
     */
    public Employee() {}

    /**
     * Overload Constructor
     * @param id_employee
     * @param id_department
     * @param first_name
     * @param last_name
     * @param age
     */
    public Employee(int id_employee, int id_department, String first_name, String last_name, int age) {
        super();
        this.id_employee=id_employee;
        this.id_department=id_department;
        this.first_name=first_name;
        this.last_name=last_name;
        this.age=age;
    }

    /**
     * Overload Constructor with no department in input
     * @param id_employee
     * @param first_name
     * @param last_name
     * @param age
     */
    public Employee(int id_employee, String first_name, String last_name, int age) {
        super();
        this.id_employee=id_employee;
        this.first_name=first_name;
        this.last_name=last_name;
        this.age=age;
    }

    /**
     * Display Employee information
     * @return Employee data
     */
    public String toString() {
        return String.format("%s | %s | %s | %s | %s ", id_employee, id_department == 0 ? "Not Affected" : id_department, first_name, last_name, age);
    }

    /* Getters */

    /**
     * @return id_employee
     */
    public int getId_employee() {
        return id_employee;
    }

    /**
     * @return id_department
     */
    public int getId_department() {
        return id_department;
    }

    /**
     * @return first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @return last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @return age
     */
    public int getAge() {
        return age;
    }



    /* Setters */

    /**
     * @param id_employee
     */
    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    /**
     * @param id_department
     */
    public void setId_department(int id_department) {
        this.id_department = id_department;

    }

    /**
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @param last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
}