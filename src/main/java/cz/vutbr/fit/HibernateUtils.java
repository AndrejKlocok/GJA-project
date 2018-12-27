package cz.vutbr.fit;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate builder class, that creates session factory from .cfg file
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
public class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    // Hibernate 5:
    private static SessionFactory buildSessionFactory() {
        try {
            // Vytvorenie serviceRegistry z configuracneho subora hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
                    .configure("hibernate.cfg.xml").build();

            // Vytvorenie metadat zdrojov pouzitim service registry
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}