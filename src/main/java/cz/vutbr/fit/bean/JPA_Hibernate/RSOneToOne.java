package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.IsicDAO;
import cz.vutbr.fit.DAO.StudentDAO;
import cz.vutbr.fit.models.ISIC;
import cz.vutbr.fit.models.Student;

import javax.faces.bean.ManagedBean;
import java.util.Date;

/**
 * Managed bean for RSOneToOne page
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
@ManagedBean(name = "RSOneToOne")
public class RSOneToOne extends NotifyGui{
    //db repositories
    private StudentDAO studentDAO = new StudentDAO();
    private IsicDAO isicDAO = new IsicDAO();

   //properties
    private String login;       //student login
    private String isicNumb;    //isic number
    private String faculty;     //faculty name
    private String isicNumbDel; //number od isic to be deleted

    /**
     * Method adds isic to Student
     */
    public void addIsicToStudent(){
        Student s;
        ISIC isic;

        //find instance in db
        s = studentDAO.getStudent(login);
        //if it doesnot exist create it
        if(s == null){
            addMessage("Entity already exists", "");
            return;
        }
        //One to one association
        isic = new ISIC(isicNumb, faculty);
        //insert isic into db
        if(!isicDAO.inserIsic(isic)){
            addMessage("Isic was not created", "");
        }
        //One to one association
        s.setIsic(isic);

        //update student
        if(!studentDAO.updateStudent(s)){
            addMessage("Student was not updated", "");
        }
        //notify
        addMessage("Success", "");
    }

    /**
     * Method removes isic
     */
    public void removeIsic(){
        ISIC isic;
        Student student;

        //get student obj by isic number
        student = studentDAO.getStudentByISIC(isicNumbDel);
        if(student == null){
            addMessage("Student not found", "");
            return;
        }
        //get isic from student obj
        isic = student.getIsic();

        //update association
        student.setIsic(null);
        if(!studentDAO.updateStudent(student)){
            addMessage("Student was not updated", "");
        }

        //delete obj
        if(!isicDAO.deleteIsic(isic.getIsic_number())){
            addMessage("Isic was not deleted", "");
        }
        //notify
        addMessage("Success", "");
    }

    //getters and setters of properties
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
