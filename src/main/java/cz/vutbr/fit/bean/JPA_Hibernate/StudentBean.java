package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.StudentDAO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Date;

/**
 * Student main bean, that contains main properties of model
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
@ManagedBean(name = "StudentBean")
public class StudentBean extends NotifyGui{
    //db service
    protected StudentDAO studentDAO = new StudentDAO();

    //managed properties on page
    protected Long id;
    protected String name;
    protected String login;
    protected Date signed;

    //getters and setters of properties
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSigned() {
        return signed;
    }

    public void setSigned(Date signed) {
        this.signed = signed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

}
