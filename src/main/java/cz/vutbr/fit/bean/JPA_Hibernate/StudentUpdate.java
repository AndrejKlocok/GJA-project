package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.models.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Managed bean for CRUD page
 */
@ManagedBean(name = "StudentUpdate")
public class StudentUpdate {
    protected StudentDAO studentDAO = new StudentDAO();

    private Long id;
    private String name;
    private String login;
    private Date signed;

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

    public String getLogin() {
        return login;

    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void findStudent(){
        Student s = studentDAO.getStudent(login);
        if(s == null){
            return;
        }

        id = s.getId();
        login = s.getLogin();
        name = s.getName();
        signed = s.getSigned();
    }

    public void  updateStudent(){
        Student s = studentDAO.getStudent(login);
        if(s == null){
            return;
        }
        s.setName(name);

        studentDAO.updateStudent(s);

    }

}
