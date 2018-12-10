package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.StudentDAO;

import javax.faces.bean.ManagedBean;
import java.util.Date;

@ManagedBean(name = "StudentBean")
public class StudentBean {
    protected StudentDAO studentDAO = new StudentDAO();

    protected Long id;
    protected String name;
    protected String login;
    protected Date signed;

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
