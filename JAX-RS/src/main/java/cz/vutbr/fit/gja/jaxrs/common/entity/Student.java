package cz.vutbr.fit.gja.jaxrs.common.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Martin Kocour
 * created on 03/01/2019
 *
 * Simple entity for JAX-RS example.
 */
public class Student {
    private String forename;
    private String surname;
    private String login;

    public Student() {
    }

    public Student(String forename, String surname, String login) {
        this.forename = forename;
        this.surname = surname;
        this.login = login;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
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
