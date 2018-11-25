package cz.vutbr.fit.DAO;

import cz.vutbr.fit.models.ISIC;
import org.hibernate.Transaction;
import org.primefaces.push.annotation.Singleton;


import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

@Singleton
public class IsicDAO  extends  DAO{

    public ISIC getIsic(String isicNumberString) {
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            ISIC  isic = (ISIC) em.createQuery(
                    "SELECT i from ISIC i where i.isic_number = :isic_number")
                    .setParameter("isic_number", isicNumberString)
                    .getSingleResult();

            tr.commit();

            if(isic == null){
                addMessage("Not found", "Entity found");
            }
            else{
                addMessage("Success", "Entity found");
            }
            return isic;
        }
        catch (NoResultException e) {
            tr.rollback();
            addMessage("Failure", "Entity not found");
            return null;
        }
    }

    public boolean inserIsic(ISIC isic) {
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            em.persist(isic);
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

    public boolean deleteIsic(String isicNumber) {
        EntityTransaction tr = em.getTransaction();
        try {
            ISIC isic = getIsic(isicNumber);
            if(isic == null){
                addMessage("Failure 404", "Entry not found");
                return  false;
            }
            tr.begin();
            em.remove(isic);
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

    public boolean updateIsic(ISIC isic){
        EntityTransaction tr = em.getTransaction();

        try{
            tr.begin();
            em.merge(isic);
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
