package cz.vutbr.fit.gja.spring.bean.xml.di;

import java.util.List;
import java.util.Map;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 *
 * This examples shows how dependency injection (DI) works.
 * Car consit of wheels, seats, engine and steering wheel in this simple example.
 *
 * All used beans are declared in beans.xml
 */
public class Car {
    private List<String> wheels;
    private Map<String, Seat> seats;
    private Engine engine;
    private SteeringWheel steeringWheel;

    public Car(Engine engine, SteeringWheel steeringWheel, List<String> wheels, Map<String, Seat> seats) {
        this.engine = engine;
        this.wheels = wheels;
        this.seats = seats;
        this.steeringWheel = steeringWheel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car: {");
        sb.append("\n\t");
        sb.append(engine.toString());
        sb.append("\n\t");
        sb.append(steeringWheel.toString());
        seats.forEach((s, seat) -> sb.append("\n\t" + seat.toString()));
        wheels.forEach(wheel -> sb.append("\n\tWheel: " + wheel));
        sb.append("}");
        return sb.toString();
    }

    public Seat getSeat(String position) {
        return seats.get(position);
    }
}
