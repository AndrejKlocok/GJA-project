package cz.vutbr.fit.bean.JPA_Hibernate;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Simple notification of gui using FacesContext
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
public class NotifyGui {
    /**
     * Notify gui with message
     * @param summary   brief headline
     * @param detail    concrete detail
     */
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
