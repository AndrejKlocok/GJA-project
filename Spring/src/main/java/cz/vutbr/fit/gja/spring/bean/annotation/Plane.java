package cz.vutbr.fit.gja.spring.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 */
public class Plane {
    @Autowired
    private Cockpit cockpit;
    @Value("#{passengers}")
    private Map<PassengerSeat, Person> passengers;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Plane:\t");
        sb.append("Cockpit: ").append(cockpit.toString()).append("\t");
        sb.append("Seats: ");
        passengers.forEach((s, p) -> sb.append(s.toString()).append(": ").append(p == null ? "Free" : p.toString()).append("\t"));
        return sb.toString();
    }
}
