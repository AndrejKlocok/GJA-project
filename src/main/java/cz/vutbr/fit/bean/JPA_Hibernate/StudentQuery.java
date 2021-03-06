package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.StudentDAO;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Managed bean for Query page
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
@ManagedBean(name = "StudentQuery")
public class StudentQuery extends StudentUpdate{
    /**
     * Method calls query to fix wrong input vals
     */
    public void fixStudentvalues(){
        studentDAO.namedUpdate();
        //notify
        addMessage("Success", "Query run completed");
    }
}
