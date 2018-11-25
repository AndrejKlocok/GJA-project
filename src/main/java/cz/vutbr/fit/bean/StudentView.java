package cz.vutbr.fit.bean;

import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.models.Student;
import org.primefaces.push.annotation.Singleton;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "StudentView")
public class StudentView {

    private StudentDAO studentDAO = new StudentDAO();
    private List<Student> students = new ArrayList<>();

    public void setStudents(List<Student> students) {

        this.students = students;
    }

    public List<Student> getStudents(){
        this.students = studentDAO.getAll();
        return  students;
    }

}
