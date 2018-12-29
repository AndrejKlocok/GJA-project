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
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
@ManagedBean(name = "HQL")
public class HQL {
    //db service
    private SubjectDAO subjectDAO = new SubjectDAO();

    //managed properties on page
    private List<Subject> subjects;     //list of subjects
    private Long subjCount;             //total numb of subjects

    //getters and setters of properties
    public List<Subject> getSubjects() {
        setSubjects(subjectDAO.getAll());
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setSubjCount(Long subjCount) {
        this.subjCount = subjCount;
    }

    public Long getSubjCount() {
        setSubjCount(subjectDAO.getSubjectCount());
        return subjCount;
    }
}
