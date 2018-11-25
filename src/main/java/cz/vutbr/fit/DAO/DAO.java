package cz.vutbr.fit.DAO;

import cz.vutbr.fit.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
    //JPA
    protected EntityManagerFactory factory = Persistence.createEntityManagerFactory("StudentsPU");
    protected EntityManager em = factory.createEntityManager();

    //Hibernate
    protected SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    //Pop Up message
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
