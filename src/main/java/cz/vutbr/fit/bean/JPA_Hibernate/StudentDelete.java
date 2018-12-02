package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.models.Student;

import javax.faces.bean.ManagedBean;

/**
 * Managed bean for CRUD page
 */
@ManagedBean(name = "StudentDelete")
public class StudentDelete {
    private StudentDAO studentDAO = new StudentDAO();
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void deleteStudent(){
        Student student = studentDAO.getStudent(login);
        if(student!=null){
            studentDAO.deleteStudent(student);
        }
    }
}
