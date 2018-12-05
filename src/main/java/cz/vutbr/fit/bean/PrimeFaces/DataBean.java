package cz.vutbr.fit.bean.PrimeFaces;

import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.bean.JPA_Hibernate.StudentView;
import cz.vutbr.fit.models.Student;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "DataBean")
public class DataBean extends StudentView {

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


}
