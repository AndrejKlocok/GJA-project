package cz.vutbr.fit.DAO;

import cz.vutbr.fit.models.Faculty;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class is database service to Faculty model (Persistent object)
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
public class FacultyDAO extends DAO {

    /**
     * Method returns single object of Faculty
     * @param name  name is unique atribute
     * @return  Faculty object
     */
    public Faculty getFaculty(String name) {
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try {
            //start transaction
            tr.begin();
            //create query to database which returns single Faculty
            Faculty  faculty = (Faculty) em.createQuery(
                    "SELECT f from Faculty f where f.name = :name")
                    .setParameter("name", name)
                    .getSingleResult();
            //commit changes
            tr.commit();
            return faculty;
        }
        catch (NoResultException e) {
            tr.rollback();
            return null;
        }
    }

    /**
     * Method returns list of all faculties in db
     * @return list of faculties
     */
    public List<Faculty> getAll(){
        //init list
        List<Faculty> students = new ArrayList<>();
        //get transaction
        EntityTransaction tr = em.getTransaction();

        try {
            //start transaction
            tr.begin();
            //create query that returns all faculties. Upt to 50 results
            students = em.createQuery("Select f FROM Faculty f").setMaxResults(50).getResultList();
            //commit transactions
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
     * Method inserts faculty into database
     * @param faculty faculty object
     * @return  true if entity was saved, false otherwise
     */
    public boolean insert(Faculty faculty) {
        //get transaction
        EntityTransaction tr = em.getTransaction();

        try {
            //start transaction
            tr.begin();
            //persist entity in database (insert)
            em.persist(faculty);
            //commit
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
     * Method deletes faculty from database according to name of faculty
     * @param name  given name
     * @return  true if entity was removed, false otherwise
     */
    public boolean delete(String name) {
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try {
            //get faculty
            Faculty faculty = getFaculty(name);
            if(faculty == null){
                return  false;
            }
            //begin transaction
            tr.begin();
            //delete faculty
            em.remove(faculty);
            //commit
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
     * Method updates faculty in database
     * @param faculty   given faculty
     * @return true if entity was updated, false otherwise
     */
    public boolean update(Faculty faculty){
        //get transaction
        EntityTransaction tr = em.getTransaction();

        try{
            //begin transaction
            tr.begin();
            //update faculty
            em.merge(faculty);
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
