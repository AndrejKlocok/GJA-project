package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.models.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Managed bean for CRUD page
 */
@ManagedBean(name = "StudentUpdate")
public class StudentUpdate extends StudentFind {
    /**
     * Method update student state to database
     */
    public void  updateStudent(){
        //get student from db
        Student s = studentDAO.getStudent(login);
        //if student does not exist
        if(s == null){
            addMessage("Failure", "Entity was not found");
            return;
        }
        //update properties
        s.setName(name);
        //call service
        if(!studentDAO.updateStudent(s)){
            addMessage("Failure", "Entity was not updated");
        }
        addMessage("Success", "Entity was updated");
    }
}
