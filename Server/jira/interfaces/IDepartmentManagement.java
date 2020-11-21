package jira.interfaces;

import javax.ejb.Remote;
import java.util.List;
import jira.exceptions.*;


@Remote
public interface IDepartmentManagement {

    public String createDepartment(int id_department, String name, int floor, int bat_number);
    public void removeDepartment(int id_department);

}