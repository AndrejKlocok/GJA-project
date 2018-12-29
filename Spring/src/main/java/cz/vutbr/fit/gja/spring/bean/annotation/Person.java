package cz.vutbr.fit.gja.spring.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 */
public class Person {
    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
