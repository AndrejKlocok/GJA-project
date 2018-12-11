package cz.vutbr.fit.bean.JPA_Hibernate;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
