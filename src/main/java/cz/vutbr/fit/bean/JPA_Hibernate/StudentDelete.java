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

    public void deleteStudent(){
        Student student = studentDAO.getStudent(login);
        if(student!=null){
            studentDAO.deleteStudent(student);
        }
    }
}
