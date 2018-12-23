package cz.vutbr.fit.gja.spring.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 */
public class Cockpit {
    private Person captain;
    private Person copilot;

    @Autowired
    public Cockpit(@Qualifier("martin") Person captain, @Qualifier("michal") Person copilot) {
        this.captain = captain;
        this.copilot = copilot;
    }

    @Override
    public String toString() {
        return "Captain: " + captain.toString() +
                " Co-pilot: " + copilot.toString();
    }
}
