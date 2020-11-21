package jira.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import java.io.Serializable;


@Entity
@Table(name="department")
@NamedQueries({
        @NamedQuery(name="displayDepartment", query="SELECT d FROM Department d"),
        @NamedQuery(name="removeDep", query="DELETE FROM Department d WHERE d.id_department =  :id_department")
})
public class Department implements Serializable {

    /**
     * Attributes
     */
    @Id
    private int id_department;
    private String name;
    private int floor;
    private int bat_number;
    private int nbemployee;

    /**
     * Constructor
     */
    public Department() { super();}

    /**
     * Overload Constructor
     * @param id_department
     * @param name
     * @param floor
     * @param bat_number
     */
    public Department(int id_department, String name, int floor, int bat_number) {
        super();
        this.id_department=id_department;
        this.name=name;
        this.floor=floor;
        this.bat_number=bat_number;
        this.nbemployee = 0;
    }

    /**
     * Display Department information
     * @return Department data
     */
    public String toString() {
        return String.format(" %s | %s | %s | %s | %s", id_department, name, floor, bat_number, nbemployee);
    }

    /* Getters */

    /**
     * @return id_department
     */
    public int getId_department() {
        return id_department;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * @return bat_number
     */
    public int getBat_number() {
        return bat_number;
    }

    /**
     *
     * @return
     */
    public int getNbemployee() {
        return nbemployee;
    }


    /* Setters */

    /**
     * @param id_department
     */
    public void setId_department(int id_department) {
        this.id_department = id_department;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param floor
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * @param bat_number
     */
    public void setBat_number(int bat_number) {
        this.bat_number = bat_number;
    }

    /**
     *
     * @param nbemployee
     */
    public void setNbemployee(int nbemployee) {
        this.nbemployee = nbemployee;
    }
}