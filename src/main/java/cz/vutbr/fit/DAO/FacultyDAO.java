package cz.vutbr.fit.DAO;

import cz.vutbr.fit.models.Faculty;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAO extends DAO {


    public Faculty getFaculty(String name) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Faculty  faculty = (Faculty) em.createQuery(
                    "SELECT f from Faculty f where f.name = :name")
                    .setParameter("name", name)
                    .getSingleResult();

            tr.commit();

            if(faculty == null){
                addMessage("Not found", "Entity found");
            }
            else{
                addMessage("Success", "Entity found");
            }
            return faculty;
        }
        catch (NoResultException e) {
            tr.rollback();
            addMessage("Failure", "Entity found");
            return null;
        }
    }

    public List<Faculty> getAll(){
        List<Faculty> students = new ArrayList<>();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            students = em.createQuery("Select f FROM Faculty f").setMaxResults(50).getResultList();
            tr.commit();
            return students;
        }
        catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return students;
        }
    }

    public boolean insert(Faculty faculty) {
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            em.persist(faculty);
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
            Faculty faculty = getFaculty(name);
            if(faculty == null){
                addMessage("Failure 404", "Entry not found");
                return  false;
            }
            tr.begin();
            em.remove(faculty);
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

    public boolean update(Faculty faculty){
        EntityTransaction tr = em.getTransaction();

        try{
            tr.begin();
            em.merge(faculty);
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
