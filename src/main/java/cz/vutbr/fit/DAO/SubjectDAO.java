package cz.vutbr.fit.DAO;

import cz.vutbr.fit.models.Subject;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends DAO {
    /**
     * Method returns single object of Subject
     * @param name  unique property of subject
     * @return  Subject object
     */
    public Subject getSubject(String name) {
        //get transaction
        EntityTransaction tr = em.getTransaction();

        try {
            //begin transaction
            tr.begin();
            //query that returns subject
            Subject  faculty = (Subject) em.createQuery(
                    "SELECT s from Subject s where s.name = :name")
                    .setParameter("name", name)
                    .getSingleResult();

            tr.commit();
            return faculty;
        }
        catch (NoResultException e) {
            tr.rollback();
            return null;
        }
    }

    /**
     * Method returns list of all subjects in db
     * @return list of subjects
     */
    public List<Subject> getAll(){
        //get session
        Session session = sessionFactory.getCurrentSession();
        //init list
        List<Subject> subjects = new ArrayList<>();
        //get transaction
        Transaction tr = session.getTransaction();
        //query
        String hql = "FROM Subject AS S";

        try {
            //begin transaction
            tr.begin();
            //create query
            Query query = session.createQuery(hql);
            //execute query and get results
            subjects =  query.setMaxResults(50).list();
            tr.commit();
            return subjects;
        }
        catch (Exception e) {
            e.printStackTrace();
            return subjects;
        }
    }

    /**
     * Method returns count of all subjects
     * @return Long count
     */
    public Long getSubjectCount(){
        //get session
        Session session = sessionFactory.getCurrentSession();
        //get transaction
        Transaction tr = session.getTransaction();
        //query
        String hql = "Select count(*) AS subjects From Subject ";
        //count
        Long count = 0L;
        try {
            //begin transaction
            tr.begin();
            //create query
            Query query = session.createQuery(hql);
            //execute query and get single result
            count = (Long) query.getSingleResult();
            tr.commit();
            return count;
        }
        catch (Exception e) {
            e.printStackTrace();
            return count;
        }
    }

    /**
     * Method inserts subject into database
     * @param subject   given subject
     * @return  true if entity was saved, false otherwise
     */
    public boolean insert(Subject subject) {
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try {
            //begin transaction
            tr.begin();
            //save subject
            em.persist(subject);
            //commit changes
            tr.commit();
            return true;
        }
        catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method deletes subject from database according to name of faculty
     * @param name  given unique property
     * @return  true if entity was removed, false otherwise
     */
    public boolean delete(String name) {
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try {
            //get subject
            Subject subject = getSubject(name);
            if(subject == null){
                return  false;
            }
            //begin transaction
            tr.begin();
            //remove subject
            em.remove(subject);
            //commit changes
            tr.commit();
            return true;
        }
        catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method updates subject in database
     * @param subject   given subject
     * @return true if entity was updated, false otherwise
     */
    public boolean update(Subject subject){
        //get transaction
        EntityTransaction tr = em.getTransaction();

        try{
            //begin transaction
            tr.begin();
            //update subject
            em.merge(subject);
            //commit changes
            tr.commit();

            return true;
        }
        catch (Exception e){
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
