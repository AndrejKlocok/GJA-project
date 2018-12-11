package cz.vutbr.fit.DAO;

import cz.vutbr.fit.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Parent class that holds connections through JPA and Hibernate
 */
public class DAO {
    //JPA
    protected EntityManagerFactory factory = Persistence.createEntityManagerFactory("StudentsPU");
    protected EntityManager em = factory.createEntityManager();

    //Hibernate
    protected SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

}
