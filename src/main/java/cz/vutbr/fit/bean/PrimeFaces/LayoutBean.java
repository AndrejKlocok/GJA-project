package cz.vutbr.fit.bean.PrimeFaces;

import cz.vutbr.fit.DAO.FacultyDAO;
import cz.vutbr.fit.DAO.SubjectDAO;
import cz.vutbr.fit.models.Faculty;
import cz.vutbr.fit.models.Subject;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "LayoutBean")
public class LayoutBean {
    private FacultyDAO facultyDAO = new FacultyDAO();

    private List<Faculty> faculties;

    public void onClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Faculty> getFaculties() {
        faculties = facultyDAO.getAll();
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
