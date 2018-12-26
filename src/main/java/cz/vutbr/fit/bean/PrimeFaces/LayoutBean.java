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

/**
 * Managed bean for Layout page
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
@ManagedBean(name = "LayoutBean")
public class LayoutBean {
    //db service
    private FacultyDAO facultyDAO = new FacultyDAO();
    //managed property
    private List<Faculty> faculties;

    /**
     * Method is listener to on clone panel event
     * @param event event
     */
    public void onClose(CloseEvent event) {
        //notify gui with faces message
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Method is listener to on toggle panel event
     * @param event event
     */
    public void onToggle(ToggleEvent event) {
        //notify gui with faces message
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    //Getters and setters
    public List<Faculty> getFaculties() {
        faculties = facultyDAO.getAll();
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
