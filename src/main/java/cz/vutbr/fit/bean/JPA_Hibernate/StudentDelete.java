package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.models.Student;

import javax.faces.bean.ManagedBean;
import java.util.Date;

/**
 * Managed bean for CRUD page
 */
@ManagedBean(name = "StudentDelete")
public class StudentDelete extends StudentBean{

    /**
     * Method deletes student from database if he exists
     */
    public void deleteStudent(){
        //get student from database
        Student student = studentDAO.getStudent(login);
        //if exists
        if (student == null) {
            addMessage("Failure", "Entity was not found");
            return;
        }

        if(!studentDAO.deleteStudent(student)){
            addMessage("Failure", "Entity was not deleted");
        }

        //notify gui
        addMessage("Success", "Entity was deleted");
    }
}
