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

    public void addStudent(){
        Student student = new Student(name, login);

        studentDAO.inserStudent(student);
    }

}
