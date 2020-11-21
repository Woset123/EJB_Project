package jira.exceptions;

import javax.ejb.ApplicationException;
import jira.entities.*;

@ApplicationException(rollback=true)
public class LimitEmployees extends Exception {

    public LimitEmployees() {}

    public LimitEmployees(String msg) {
        super(msg);
    }
}