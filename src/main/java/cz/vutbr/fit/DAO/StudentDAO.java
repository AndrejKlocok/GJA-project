package cz.vutbr.fit.DAO;

import cz.vutbr.fit.models.ISIC;
import cz.vutbr.fit.models.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.push.annotation.Singleton;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Singleton
public class StudentDAO extends DAO{

    public Student getStudent(String loginParam) {
        EntityTransaction tr = em.getTransaction();;

        try {
            tr.begin();
            Student  student = (Student) em.createQuery(
                    "SELECT s from Student s where s.login = :login")
                    .setParameter("login", loginParam)
                    .getSingleResult();

            tr.commit();

            if(student == null){
                addMessage("Not found", "Entity not found");
            }
            else{
                addMessage("Success", "Entity found");
            }
            return student;
        }
        catch (NoResultException e) {
            tr.rollback();
            addMessage("Failure", "Entity was not found");
            return null;
        }
    }

    public boolean inserStudent(Student student) {
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            em.persist(student);
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

    public boolean deleteStudent(Student student) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.remove(student);
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

    public boolean updateStudent(Student student){
        EntityTransaction tr = em.getTransaction();

        try{
            tr.begin();
            em.merge(student);
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

    public List<Student> getAll(){
        List<Student> students = new ArrayList<>();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            students = em.createQuery("Select s FROM Student s").setMaxResults(50).getResultList();
            tr.commit();
            return students;
        }
        catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return students;
        }
    }

    public void namedUpdate(){
        EntityTransaction tr = em.getTransaction();

        try{
            tr.begin();
            Query q = em.createNamedQuery("Student.updateBlankName");
            q.executeUpdate();
            tr.commit();
            addMessage("Success", "Rows updated");
        }
        catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            addMessage("Failure", "An error accrued");
        }
    }

    public Student getStudentByISIC(String isicNumberString){
        EntityTransaction tr = em.getTransaction();
        Student student;
        try{
            tr.begin();
            student = (Student) em.createQuery(
                    "Select s from Student s JOIN ISIC i ON(s.isic.id = i.id) WHERE i.isic_number = :isicNumb")
                    .setParameter("isicNumb", isicNumberString)
                    .getSingleResult();
            tr.commit();
            addMessage("Success", "Rows updated");
            return  student;
        }
        catch (Exception e) {
            tr.rollback();
            addMessage("Failure", "An error accrued");
            return null;
        }
    }

    public List<Student> getStudentsWithIsic(){
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        List<Student> students = new ArrayList<>();

        try {
            tr.begin();
            Criteria cr = session.createCriteria(Student.class);
            cr.add(Restrictions.isNotNull("isic"));
            cr.addOrder(Order.asc("name"));
            students = cr.list();
            tr.commit();
            return students;
        }
        catch (Exception e) {
            e.printStackTrace();
            return students;
        }
    }

    public Long getDiscNameCount(){
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        Long count = 0L;

        try {
            tr.begin();
            Criteria cr = session.createCriteria(Student.class);
            cr.setProjection(Projections.countDistinct("name"));
            cr.add(Restrictions.ilike("login", "x%"));
            cr.addOrder(Order.asc("login"));
            count = (Long) cr.uniqueResult();
            tr.commit();
            return count;
        }
        catch (Exception e) {
            e.printStackTrace();
            return count;
        }
    }

}
