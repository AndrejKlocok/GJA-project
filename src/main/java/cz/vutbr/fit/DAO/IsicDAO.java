package cz.vutbr.fit.DAO;

import cz.vutbr.fit.models.ISIC;
import org.hibernate.Transaction;
import org.primefaces.push.annotation.Singleton;


import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

/**
 * Class is database service to Isic model (Persistent object)
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
@Singleton
public class IsicDAO  extends  DAO{
    /**
     * Method returns single object of Isic
     * @param isicNumberString  given unique property
     * @return Isic object
     */
    public ISIC getIsic(String isicNumberString) {
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try {
            //begin transaction
            tr.begin();
            //execute query which returns single Isic
            ISIC  isic = (ISIC) em.createQuery(
                    "SELECT i from ISIC i where i.isic_number = :isic_number")
                    .setParameter("isic_number", isicNumberString)
                    .getSingleResult();

            tr.commit();
            return isic;
        }
        catch (NoResultException e) {
            tr.rollback();
            return null;
        }
    }

    /**
     * Method inserts isic into database
     * @param isic given isic
     * @return  true if entity was saved, false otherwise
     */
    public boolean inserIsic(ISIC isic) {
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try {
            //begin transaction
            tr.begin();
            //save isic object
            em.persist(isic);
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
     * Method deletes isic from database according to isic number
     * @param isicNumber unique isic number
     * @return true if entity was removed, false otherwise
     */
    public boolean deleteIsic(String isicNumber) {
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try {
            //get isic object
            ISIC isic = getIsic(isicNumber);
            if(isic == null){
                return  false;
            }
            //begin transaction
            tr.begin();
            //remove isic from persistent obj
            em.remove(isic);
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
     * Method updates isic in database
     * @param isic given isic object
     * @return true if entity was updated, false otherwise
     */
    public boolean updateIsic(ISIC isic){
        //get transaction
        EntityTransaction tr = em.getTransaction();
        try{
            //begin transaction
            tr.begin();
            //update object
            em.merge(isic);
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
