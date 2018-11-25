package cz.vutbr.fit.bean;

import cz.vutbr.fit.DAO.StudentDAO;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "StudentQuery")
public class StudentQuery {
    private StudentDAO studentDAO = new StudentDAO();

    public void fixStudentvalues(){

        studentDAO.namedUpdate();
        RequestContext.getCurrentInstance().update("table1");

    }
}
