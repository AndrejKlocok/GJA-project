package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.models.Student;

import javax.faces.bean.ManagedBean;

/**
 * Managed bean for CRUD page
 */
@ManagedBean(name = "StudentInsert")
public class StudentInsert {
    private StudentDAO studentDAO = new StudentDAO();

    private String name;
    private String login;

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

    public void addStudent(){
        Student student = new Student(name, login);

        studentDAO.inserStudent(student);
    }
}
