package cz.vutbr.fit.DAO;

import cz.vutbr.fit.models.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends DAO {

    public Subject getSubject(String name) {
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            Subject  faculty = (Subject) em.createQuery(
                    "SELECT s from Subject s where s.name = :name")
                    .setParameter("name", name)
                    .getSingleResult();

            tr.commit();

            if(faculty == null){
                addMessage("Not found", "Entity not found");
            }
            else{
                addMessage("Success", "Entity found");
            }
            return faculty;
        }
        catch (NoResultException e) {
            tr.rollback();
            addMessage("Failure", "Entity was not found");
            return null;
        }
    }


    public List<Subject> getAll(){
        Session session = sessionFactory.getCurrentSession();
        List<Subject> subjects = new ArrayList<>();
        Transaction tr = session.getTransaction();
        String hql = "FROM Subject AS S";

        try {
            tr.begin();
            Query query = session.createQuery(hql);
            subjects =  query.setMaxResults(50).list();
            tr.commit();
            return subjects;
        }
        catch (Exception e) {
            e.printStackTrace();
            return subjects;
        }
    }

    public Long getSubjectCount(){
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        String hql = "Select count(*) AS subjects From Subject ";

        Long count = 0L;
        try {
            tr.begin();
            Query query = session.createQuery(hql);
            count = (Long) query.getSingleResult();
            tr.commit();
            return count;
        }
        catch (Exception e) {
            e.printStackTrace();
            return count;
        }
    }

    public boolean insert(Subject subject) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(subject);
            tr.commit();
            addMessage("Success", "Entry created");
            return true;
        }
        catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            addMessage("Failure", "Entry was not created");
            return false;
        }
    }

    public boolean delete(String name) {
        EntityTransaction tr = em.getTransaction();
        try {
            Subject subject = getSubject(name);
            if(subject == null){
                addMessage("Failure 404", "Entry not found");
                return  false;
            }
            tr.begin();
            em.remove(subject);
            tr.commit();
            addMessage("Success", "Entry deleted");
            return true;
        }
        catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            addMessage("Failure", "An error accrued");
            return false;
        }
    }

    public boolean update(Subject subject){
        EntityTransaction tr = em.getTransaction();

        try{
            tr.begin();
            em.merge(subject);
            tr.commit();

            addMessage("Success", "Entity updated");
            return true;
        }
        catch (Exception e){
            tr.rollback();
            e.printStackTrace();
            addMessage("Failure", "An error accrued");
            return false;
        }
    }
}
