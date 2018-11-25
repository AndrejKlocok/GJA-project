package cz.vutbr.fit.bean;

import cz.vutbr.fit.DAO.IsicDAO;
import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.models.ISIC;
import cz.vutbr.fit.models.Student;

import javax.faces.bean.ManagedBean;
import java.util.Date;

@ManagedBean(name = "RSOneToOne")
public class RSOneToOne {

    private StudentDAO studentDAO = new StudentDAO();
    private IsicDAO isicDAO = new IsicDAO();

    //Student
    private String login;

    //Isic instance
    private String isicNumb;
    private String faculty;

    private String isicNumbDel;

    public void addIsicToStudent(){
        Student s;
        ISIC isic;

        //find instance in db
        s = studentDAO.getStudent(login);
        //if it doesnot exist create it
        if(s == null){
            return;
        }

        isic = new ISIC(isicNumb, faculty);

        isicDAO.inserIsic(isic);

        s.setIsic(isic);

        studentDAO.updateStudent(s);
    }

    public void removeIsic(){
        ISIC isic;
        Student student;

        student = studentDAO.getStudentByISIC(isicNumbDel);
        if(student == null){
            return;
        }
        isic = student.getIsic();

        student.setIsic(null);
        studentDAO.updateStudent(student);

        isicDAO.deleteIsic(isic.getIsic_number());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIsicNumb() {
        return isicNumb;
    }

    public void setIsicNumb(String isicNumb) {
        this.isicNumb = isicNumb;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getIsicNumbDel() {
        return isicNumbDel;
    }

    public void setIsicNumbDel(String isicNumbDel) {
        this.isicNumbDel = isicNumbDel;
    }
}
