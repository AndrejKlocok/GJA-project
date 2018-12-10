package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.models.Student;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "Criteria")
public class Criteria {
    //db service
    private StudentDAO studentDAO = new StudentDAO();

    //managed properties
    private List<Student> students;             //list of students
    private List<Student> studentsWithXlogin;   //list of students that starts with x
    private Long studCount;                     //number of students with distinct name and login starts with x

    //getters and setters of properties
    public List<Student> getStudents() {
        this.students = studentDAO.getStudentsWithIsic();
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public Long getStudCount() {
        this.studCount = studentDAO.getDiscNameCount();
        return studCount;
    }

    public void setStudCount(Long studCount) {
        this.studCount = studCount;
    }

    public List<Student> getStudentsWithXlogin() {
        this.studentsWithXlogin = studentDAO.getStudentsWithXlogin();
        return studentsWithXlogin;
    }

    public void setStudentsWithXlogin(List<Student> studentsWithXlogin) {
        this.studentsWithXlogin = studentsWithXlogin;
    }
}
