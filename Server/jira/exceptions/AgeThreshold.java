package jira.exceptions;

import javax.ejb.ApplicationException;
import jira.entities.*;

@ApplicationException(rollback=true)
public class AgeThreshold extends Exception {

    /**
     * Create new AgeThreshold instance
     */
    public AgeThreshold() {}

    /**
     * Create new AgeThreshold instance
     * @param msg display exception
     */
    public AgeThreshold(String msg) {
        super(msg);
    }
}
