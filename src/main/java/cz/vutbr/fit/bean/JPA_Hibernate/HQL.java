package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.FacultyDAO;
import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.DAO.SubjectDAO;
import cz.vutbr.fit.models.Student;
import cz.vutbr.fit.models.Subject;

import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Managed bean for HQL page
 */
@ManagedBean(name = "HQL")
public class HQL {
    //db objects
    private StudentDAO studentDAO = new StudentDAO();
    private SubjectDAO subjectDAO = new SubjectDAO();

    //managed properties on page
    private List<Subject> subjects;     //list of subjects
    private List<Student> students;     //list of students
    private Long subjCount;             //total numb of subjects
    private Long studCount;             //number of students with distinct name and login starts with x


    //getters and setters of properties
    public List<Subject> getSubjects() {
        setSubjects(subjectDAO.getAll());
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }


    public List<Student> getStudents() {
        this.students = studentDAO.getStudentsWithIsic();
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setSubjCount(Long subjCount) {
        this.subjCount = subjCount;
    }

    public Long getSubjCount() {
        setSubjCount(subjectDAO.getSubjectCount());
        return subjCount;
    }

    public Long getStudCount() {
        this.studCount = studentDAO.getDiscNameCount();
        return studCount;
    }

    public void setStudCount(Long studCount) {
        this.studCount = studCount;
    }
}
