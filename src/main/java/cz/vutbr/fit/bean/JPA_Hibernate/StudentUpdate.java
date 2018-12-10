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

    public void  updateStudent(){
        Student s = studentDAO.getStudent(login);
        if(s == null){
            return;
        }
        s.setName(name);

        studentDAO.updateStudent(s);
    }
}
