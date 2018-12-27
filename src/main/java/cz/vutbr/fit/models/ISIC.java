package cz.vutbr.fit.models;

import javax.persistence.*;
import java.util.Date;

/**
 * ISIC model (Persistent object)
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
@Entity
public class ISIC {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable=false, unique=true)
    private Long id;

    @Column( nullable=false, unique=true)
    private String isic_number;

    @Column( nullable = true, unique = false)
    private String faculty;

    @Column( nullable=false, unique=false)
    private Date creation;


    public ISIC(){}

    public ISIC(String isic_number, String faculty) {
        this.isic_number = isic_number;
        this.faculty = faculty;
        this.creation = new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsic_number() {
        return isic_number;
    }

    public void setIsic_number(String isic_number) {
        this.isic_number = isic_number;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date expiration) {
        this.creation = expiration;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "ISIC{" +
                "id=" + id +
                ", isic_number='" + isic_number + '\'' +
                ", expiration=" + creation +
                '}';
    }
}
