package cz.vutbr.fit.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable=false, unique=true)
    private Long id_subject;

    @Column( nullable=false)
    private String name;

    @Column( nullable=false)
    private Date created;

    @ManyToOne
    @JoinTable(name = "Faculty_Subject",
            joinColumns = {@JoinColumn(name = "fk_subject", insertable = false, updatable = false,
                    referencedColumnName = "id_subject")},
            inverseJoinColumns = {@JoinColumn(name = "fk_faculty", insertable = false, updatable = false,
                    referencedColumnName = "id_faculty")}
    )
    private Faculty subjectFaculty;

    public Subject(){}

    public Subject(String name) {
        this.name = name;
        this.created = new Date(System.currentTimeMillis());
    }

    public Long getId_subject() {
        return id_subject;
    }

    public void setId_subject(Long id) {
        this.id_subject = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Faculty getSubjectFaculty() {
        return subjectFaculty;
    }

    public void setSubjectFaculty(Faculty subjectFaculty) {
        this.subjectFaculty = subjectFaculty;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id_subject +
                ", name='" + name + '\'' +
                '}';
    }
}
