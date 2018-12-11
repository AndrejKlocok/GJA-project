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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Singleton
public class StudentDAO extends DAO{
    /**
     * Method returns single object of Student
     * @param loginParam    given unique property
     * @return Student object
     */
    public Student getStudent(String loginParam) {
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try {
            //begin transaction
            tr.begin();
            //execute query that returns single result
            Student  student = (Student) em.createQuery(
                    "SELECT s from Student s where s.login = :login")
                    .setParameter("login", loginParam)
                    .getSingleResult();

            tr.commit();
            return student;
        }
        catch (NoResultException e) {
            tr.rollback();
            return null;
        }
    }

    /**
     * Method inserts student into database
     * @param student   given student object
     * @return true if entity was saved, false otherwise
     */
    public boolean inserStudent(Student student) {
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try {
            //begin transaction
            tr.begin();
            //persit object
            em.persist(student);
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
     * Method deletes Student from database according to login property
     * @param student   given student
     * @return true if entity was removed, false otherwise
     */
    public boolean deleteStudent(Student student) {
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try {
            //begin transaction
            tr.begin();
            //remove object
            em.remove(student);
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
     * Method updates Student in database
     * @param student   given student
     * @return  true if entity was updated, false otherwise
     */
    public boolean updateStudent(Student student){
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try{
            //begin transaction
            tr.begin();
            //update object
            student.setSigned(new Date(System.currentTimeMillis()));
            em.merge(student);
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

    /**
     * Method returns list of all students in db
     * @return  list of all students
     */
    public List<Student> getAll(){
        //init list
        List<Student> students = new ArrayList<>();
        //get transaction
        EntityTransaction tr = em.getTransaction();

        try {
            //begin transaction
            tr.begin();
            //query that returns 50 results
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

    /**
     * Method performs named query which updates blank name properties
     */
    public void namedUpdate(){
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try{
            //begin transaction
            tr.begin();
            //create update named query from local
            Query q = em.createNamedQuery("Student.updateBlankName");
            //execute
            q.executeUpdate();
            //commit changes
            tr.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }

    /**
     * Method returns student by isic number string which is 1 to 1 association
     * @param isicNumberString  given isic string
     * @return  Student object
     */
    public Student getStudentByISIC(String isicNumberString){
        //get transaction
        EntityTransaction tr = em.getTransaction();
        Student student;
        try{
            //begin transaction
            tr.begin();
            //query that returns student according to association
            student = (Student) em.createQuery(
                    "Select s from Student s JOIN ISIC i ON(s.isic.id = i.id) WHERE i.isic_number = :isicNumb")
                    .setParameter("isicNumb", isicNumberString)
                    .getSingleResult();
            tr.commit();
            return  student;
        }
        catch (Exception e) {
            tr.rollback();
            return null;
        }
    }

    /**
     * Method returns list of Students, in which every student has isic
     * @return
     */
    public List<Student> getStudentsWithIsic(){
        //get session
        Session session = sessionFactory.getCurrentSession();
        //get transaction
        Transaction tr = session.getTransaction();
        //init list
        List<Student> students = new ArrayList<>();

        try {
            //begin transaction
            tr.begin();
            //create criteria under Student class
            Criteria cr = session.createCriteria(Student.class);
            //add not null
            cr.add(Restrictions.isNotNull("isic"));
            //order by name ascending
            cr.addOrder(Order.asc("name"));
            //get list
            students = cr.list();
            tr.commit();
            return students;
        }
        catch (Exception e) {
            e.printStackTrace();
            return students;
        }
    }

    /**
     * Method returns distinct count of student which login start with x and distinct name.
     * @return Long
     */
    public Long getDiscNameCount(){
        //get session
        Session session = sessionFactory.getCurrentSession();
        //get transaction
        Transaction tr = session.getTransaction();
        //init cound
        Long count = 0L;

        try {
            //start transaction
            tr.begin();
            //create criteria under Student class
            Criteria cr = session.createCriteria(Student.class);
            //count distinct
            cr.setProjection(Projections.countDistinct("name"));
            //login like x%
            cr.add(Restrictions.ilike("login", "x%"));
            //order by login ascending
            cr.addOrder(Order.asc("login"));
            //get unique result
            count = (Long) cr.uniqueResult();
            tr.commit();
            return count;
        }
        catch (Exception e) {
            e.printStackTrace();
            return count;
        }
    }

    /**
     * Method returns list of students, which login starts with x
     * @return list of students
     */
    public List<Student> getStudentsWithXlogin(){
        //get transaction
        EntityTransaction tr = em.getTransaction();
        //init list
        List<Student> students = new ArrayList<>();
        //get criteria builder
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        //create query on object Student
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        try {
            tr.begin();
            //create root from class
            Root<Student> root = criteriaQuery.from(Student.class);
            //JPA criteria query
            criteriaQuery.select(root).where(criteriaBuilder.like(root.get("login"),"x%"))
                    .orderBy(criteriaBuilder.asc(root.get("login")));
            //create query
            students = em.createQuery(criteriaQuery).getResultList();
            tr.commit();
            return students;
        }
        catch (Exception e) {
            e.printStackTrace();
            return students;
        }
    }
}
