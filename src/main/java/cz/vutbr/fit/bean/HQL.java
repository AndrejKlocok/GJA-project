package cz.vutbr.fit.bean;

import cz.vutbr.fit.DAO.FacultyDAO;
import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.DAO.SubjectDAO;
import cz.vutbr.fit.models.Student;
import cz.vutbr.fit.models.Subject;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "HQL")
public class HQL {
    private StudentDAO studentDAO = new StudentDAO();
    private SubjectDAO subjectDAO = new SubjectDAO();

    private List<Subject> subjects;
    private List<Student> students;
    private Long subjCount;     //total numb of subjects
    private Long studCount;     //number of students with distinct name and login starts with x

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
