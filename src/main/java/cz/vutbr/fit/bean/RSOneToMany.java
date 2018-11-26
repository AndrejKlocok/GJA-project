package cz.vutbr.fit.bean;

import cz.vutbr.fit.DAO.FacultyDAO;
import cz.vutbr.fit.DAO.SubjectDAO;
import cz.vutbr.fit.models.Faculty;
import cz.vutbr.fit.models.Subject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "RSOneToMany")
public class RSOneToMany {

    private FacultyDAO facultyDAO = new FacultyDAO();
    private SubjectDAO subjectDAO = new SubjectDAO();


    private String facultyName;
    private String subjectName;

    private String toFacultyAddSubj;
    private String subjectNameDel;


    private List<Faculty> faculties = new ArrayList<>();

    public void createFaculty(){
        Faculty faculty = new Faculty(facultyName);
        facultyDAO.insert(faculty);
    }

    public void removeFaculty(){
        Faculty faculty;

        faculty = facultyDAO.getFaculty(facultyName);
        if(faculty == null){
            return;
        }

        facultyDAO.delete(faculty.getName());
    }

    public void createSubject(){
        Subject subject = new Subject(subjectName);
        subjectDAO.insert(subject);
    }

    public void removeSubject(){
        Faculty faculty;
        Subject subject;

        subject = subjectDAO.getSubject(subjectNameDel);
        if(subject == null){
            return;
        }

        faculty = subject.getSubjectFaculty();

        //upravim vztahy medzi entitami
        faculty.removeSubject(subject);
        subject.setSubjectFaculty(null);

        facultyDAO.update(faculty);

        subjectDAO.delete(subject.getName());
    }

    public void addSubjectToFaculty(){
        //zistime meno fakulty
        Faculty f = facultyDAO.getFaculty(toFacultyAddSubj);
        if(f == null){
            return;
        }

        Subject subject ;
        subject = subjectDAO.getSubject(subjectName);

        //zistime ci uz predmet existuje
        if(subject != null){
            addMessage("Failure", "Subject already exists");
            return;
        }

        //vyrvorim predmet
        subject = new Subject(subjectName);
        subjectDAO.insert(subject);

        //aktualizujem vztahy
        subject.setSubjectFaculty(f);
        f.addSubject(subject);

        //mergnem fakultu
        facultyDAO.update(f);
    }



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
