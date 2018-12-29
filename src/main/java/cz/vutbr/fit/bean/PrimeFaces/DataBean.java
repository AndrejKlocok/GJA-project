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

/**
 * Managed bean for Data page
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
@ManagedBean(name = "DataBean")
public class DataBean extends StudentView {
    //db service
    private SubjectDAO subjectDAO = new SubjectDAO();
    //properties
    private List<Subject> subjects;

    /**
     * Listener for row editing
     * @param event row edit event
     */
    public void onRowEdit(RowEditEvent event) {
        //get student object
        Student student = (Student) event.getObject();
        //update
        studentDAO.updateStudent(student);
        //notify with faces message
        FacesMessage msg = new FacesMessage("Student Edited "
                + student.getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Listener for row canceling
     * @param event
     */
    public void onRowCancel(RowEditEvent event) {
        //get student object
        Student student = (Student) event.getObject();
        //remove student
        studentDAO.deleteStudent(student);
        //notify with faces message
        FacesMessage msg = new FacesMessage("Edit Cancelled "
                + ((Student) event.getObject()).getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //Getters and setters
    public List<Subject> getSubjects() {
        //retrieve students from database
        subjects = subjectDAO.getAll();
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
