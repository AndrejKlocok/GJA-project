package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.models.Student;

import javax.faces.bean.ManagedBean;
import java.util.Date;

/**
 * Managed bean for CRUD page
 */
@ManagedBean(name = "StudentInsert")
public class StudentInsert extends StudentBean{
    /**
     * Add student to database
     */
    public void addStudent(){
        //Create student
        Student student = new Student(name, login);
        //insert student to database
        if(!studentDAO.inserStudent(student)){
            //notify
            addMessage("Failure", "Entity was not created");
            return;
        }
        //notify
        addMessage("Success", "Entity was created");

    }

}
