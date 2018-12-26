package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.models.Student;

import javax.faces.bean.ManagedBean;
import java.util.Date;

/**
 * Managed bean for CRUD page
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
@ManagedBean(name = "StudentFind")
public class StudentFind extends StudentBean {
    /**
     * Method finds student from db according to login
     */
    public void findStudent(){
        //get student from db
        Student s = studentDAO.getStudent(login);
        //exists?
        if(s == null){
            //notify
            addMessage("Failure", "Entity was not found");
            return;
        }
        //notify
        addMessage("Success", "Entity was found");
        //set properties
        id = s.getId();
        login = s.getLogin();
        name = s.getName();
        signed = s.getSigned();
    }
}
