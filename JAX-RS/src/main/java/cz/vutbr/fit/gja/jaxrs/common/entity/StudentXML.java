package cz.vutbr.fit.gja.jaxrs.common.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Martin Kocour
 * created on 03/01/2019
 *
 * Simple entity for JAX-JAXB example
 */
@XmlRootElement
public class StudentXML {
    private String forename;
    private String surname;
    private String login;

    public StudentXML(String forename, String surname, String login) {
        this.forename = forename;
        this.surname = surname;
        this.login = login;
    }

    @Override
    public String toString() {
        return "Student{" +
                "forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
