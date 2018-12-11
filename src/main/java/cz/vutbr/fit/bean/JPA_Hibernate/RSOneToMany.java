package cz.vutbr.fit.bean.JPA_Hibernate;

import cz.vutbr.fit.DAO.FacultyDAO;
import cz.vutbr.fit.DAO.SubjectDAO;
import cz.vutbr.fit.models.Faculty;
import cz.vutbr.fit.models.Subject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Managed bean for OneToMany page
 */
@ManagedBean(name = "RSOneToMany")
public class RSOneToMany extends NotifyGui{
    //db objects
    private FacultyDAO facultyDAO = new FacultyDAO();
    private SubjectDAO subjectDAO = new SubjectDAO();

    //page properties
    private String facultyName;         //name of faculty
    private String subjectName;         //name of subject
    private String toFacultyAddSubj;    //name of faculty to which we add subject
    private String subjectNameDel;      //name of subject which will be deleted
    private List<Faculty> faculties = new ArrayList<>();    //list of faculties

    /**
     * Method creates faculty persistent object
     */
    public void createFaculty(){
        Faculty faculty = new Faculty(facultyName);

        if(!facultyDAO.insert(faculty)){
            addMessage("Faculty was not created", "");
        }
        addMessage("Success", "");
    }

    /**
     * Method removes faculty object according to date
     */
    public void removeFaculty(){
        Faculty faculty;

        //get faculty object by name
        faculty = facultyDAO.getFaculty(facultyName);
        if(faculty == null){
            addMessage("Faculty was not found", "");
            return;
        }

        if(!facultyDAO.delete(faculty.getName())){
            addMessage("Faculty was not deleted", "");
        }
        addMessage("Success", "");
    }

    /**
     * Method creates persistent subject object
     */
    public void createSubject(){
        Subject subject = new Subject(subjectName);

        if(!subjectDAO.insert(subject)){
            addMessage("Subject was not created", "");
        }
        addMessage("Success", "");
    }

    /**
     * Method deletes subject
     */
    public void removeSubject(){
        Faculty faculty;
        Subject subject;

        //get subject by name
        subject = subjectDAO.getSubject(subjectNameDel);
        if(subject == null){
            addMessage("Subject was not found", "");
            return;
        }
        //get faculty from association between subj and faculty
        faculty = subject.getSubjectFaculty();

        //update associations
        faculty.removeSubject(subject);
        subject.setSubjectFaculty(null);

        //merge faculty`s new state
        if(!facultyDAO.update(faculty)){
            addMessage("Faculty was not updated", "");
        }

        //remove subject
        if(!subjectDAO.delete(subject.getName())){
            addMessage("Subject was not created", "");
        }
        //notify
        addMessage("Success", "");
    }

    /**
     * Method adds subject to faculty
     */
    public void addSubjectToFaculty(){
        //get faculty by name
        Faculty f = facultyDAO.getFaculty(toFacultyAddSubj);
        if(f == null){
            addMessage("Faculty was not found", "");
            return;
        }

        Subject subject ;
        //get subject by name
        subject = subjectDAO.getSubject(subjectName);

        //if subject does not exists
        if(subject != null){
            addMessage("Failure", "Subject already exists");
            return;
        }

        //create new subject
        subject = new Subject(subjectName);
        if(!subjectDAO.insert(subject)){
            addMessage("Subject was not created", "");
        }

        //update associations
        subject.setSubjectFaculty(f);
        f.addSubject(subject);

        //merge faculty new state
        if(!facultyDAO.update(f)){
            addMessage("Faculty was not updated", "");
        }
        //notify
        addMessage("Success", "");
    }

    //getters and setters of properties

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    public List<Faculty> getFaculties() {
        faculties = facultyDAO.getAll();
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public String getSubjectNameDel() {
        return subjectNameDel;
    }

    public void setSubjectNameDel(String subjectNameDel) {
        this.subjectNameDel = subjectNameDel;
    }

    public String getToFacultyAddSubj() {
        return toFacultyAddSubj;
    }

    public void setToFacultyAddSubj(String toFacultyAddSubj) {
        this.toFacultyAddSubj = toFacultyAddSubj;
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
