package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.models.Student;

import javax.faces.bean.ManagedBean;
import java.util.Date;

@ManagedBean(name = "StudentFind")
public class StudentFind extends StudentBean {
    public void findStudent(){

        Student s = studentDAO.getStudent(login);
        if(s == null){
            return;
        }

        id = s.getId();
        login = s.getLogin();
        name = s.getName();
        signed = s.getSigned();
    }
}
