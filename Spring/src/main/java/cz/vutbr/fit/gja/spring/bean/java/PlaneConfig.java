package cz.vutbr.fit.gja.spring.bean.java;

import cz.vutbr.fit.gja.spring.bean.annotation.Cockpit;
import cz.vutbr.fit.gja.spring.bean.annotation.PassengerSeat;
import cz.vutbr.fit.gja.spring.bean.annotation.Person;
import cz.vutbr.fit.gja.spring.bean.annotation.Plane;
import cz.vutbr.fit.gja.spring.bean.xml.Car;
import cz.vutbr.fit.gja.spring.bean.xml.Seat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Martin Kocour
 * created on 23/12/2018
 */
@Configuration
public class PlaneConfig {

    @Bean
    public Plane plane1() {
        return new Plane();
    }

    @Bean
    public Map<PassengerSeat, Person> passengers() {
        Map<PassengerSeat, Person> passengers = new HashMap<>();
        passengers.put(new PassengerSeat(1), new Person("Andrej", "Klocok"));
        passengers.put(new PassengerSeat(2), new Person("Tomas", "Vlk"));
        passengers.put(new PassengerSeat(3), null);
        passengers.put(new PassengerSeat(4), null);
        return passengers;
    }

    @Bean(initMethod = "init")
    @Scope("prototype")
    public Cockpit cockpit() {
        return new Cockpit(captain(), copilot());
    }

    @Bean
    public Person captain() {
        return new Person("Martin", "Kocour");
    }

    @Bean
    public Person copilot() {
        return new Person("Michal", "Gabonay");
    }
}
