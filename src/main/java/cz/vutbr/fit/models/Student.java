package cz.vutbr.fit.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@NamedQuery(name="Student.updateBlankName", query = "UPDATE Student S SET S.name = 'MenoStudenta' WHERE S.name =''")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable=false, unique=true)
    private Long id;
    @Column( nullable=false, unique=false)
    private String name;
    @Column(nullable=false, unique=false)
    private String login;
    @Temporal(TemporalType.DATE)
    private Date signed;

    @OneToOne
    @JoinColumn(name = "isic_id")
    private ISIC isic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Constructors
    public Student(){ }

    public Student(String name, String login){
        this.name = name;
        this.login = login;
        this.signed = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", signed=" + signed +
                ", isic=" + isic +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getSigned() {
        return signed;
    }

    public void setSigned(Date signed) {
        this.signed = signed;
    }

    public ISIC getIsic() {
        return isic;
    }

    public void setIsic(ISIC isic) {
        this.isic = isic;
    }
}
