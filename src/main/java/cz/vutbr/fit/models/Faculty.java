package cz.vutbr.fit.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Faculty model (Persistent object)
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable=false, unique=true)
    private Long id_faculty;

    @Column( nullable=false, unique = true)
    private String name;

    @OneToMany( orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinTable(name = "Faculty_Subject",
            joinColumns = {@JoinColumn(name = "fk_faculty", referencedColumnName = "id_faculty")},
            inverseJoinColumns = {@JoinColumn(name = "fk_subject", referencedColumnName = "id_subject")}
    )
    private List<Subject> subjectList = new ArrayList<>();

    public Faculty(){}

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public void addSubject(Subject s){
        this.subjectList.add(s);
    }

    public void removeSubject(Subject s){
        this.subjectList.remove(s);
    }

    public Long getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(Long id_faculty) {
        this.id_faculty = id_faculty;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id_faculty=" + id_faculty +
                ", name='" + name + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }
}
