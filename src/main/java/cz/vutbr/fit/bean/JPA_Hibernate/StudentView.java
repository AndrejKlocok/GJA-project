package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.models.Student;
import org.primefaces.push.annotation.Singleton;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
/**
 * Managed bean students list
 */
@ManagedBean(name = "StudentView")
public class StudentView {

    protected StudentDAO studentDAO = new StudentDAO();
    protected List<Student> students = new ArrayList<>();

    public void setStudents(List<Student> students) {

        this.students = students;
    }

    public List<Student> getStudents(){
        this.students = studentDAO.getAll();
        return  students;
    }

}
