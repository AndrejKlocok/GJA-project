package cz.vutbr.fit.gja.spring.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 */
public class PassengerSeat {
    private Integer number;

    public PassengerSeat(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
