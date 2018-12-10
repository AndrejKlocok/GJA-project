package cz.vutbr.fit.bean.PrimeFaces;

import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.DAO.SubjectDAO;
import cz.vutbr.fit.bean.JPA_Hibernate.StudentView;
import cz.vutbr.fit.models.Student;
import cz.vutbr.fit.models.Subject;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "DataBean")
public class DataBean extends StudentView {
    private SubjectDAO subjectDAO = new SubjectDAO();
    private List<Subject> subjects;

    public void onRowEdit(RowEditEvent event) {
        Student student = (Student) event.getObject();
        studentDAO.updateStudent(student);
        FacesMessage msg = new FacesMessage("Student Edited "
                + student.getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled "
                + ((Student) event.getObject()).getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Subject> getSubjects() {
        subjects = subjectDAO.getAll();
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
