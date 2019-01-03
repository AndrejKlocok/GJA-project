package cz.vutbr.fit.gja.springmvc.entity;

import lombok.Data;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Martin Kocour
 * created on 29/12/2018
 *
 * This class correspondent to one record in Student table.
 *
 *
 * {@link Data} is a Lombok annotation to create all the getters,
 * setters, equals, hash, and toString methods, based on the fields.
 * {@link Entity} is a JPA annotation to make this object ready for
 * storage in a JPA-based data store.
 *
 * The code was inspired by this tutorial
 * https://spring.io/guides/tutorials/rest/
 */
@Data
@Table(name = "Student")
@Entity
public class Student {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
    private String name;
    private String login;
    private Date signed;
    @Column(name = "isic_id")
    private Integer isicId;

    public Student() {
        this.signed = new Date(0L);
    }

    public Student(String name, String login, Integer isicId) {
        this();
        this.name = name;
        this.login = login;
        this.isicId = isicId;
    }

}
