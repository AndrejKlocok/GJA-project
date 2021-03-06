package cz.vutbr.fit.gja.spring.bean.xml.di;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 *
 * This examples shows how dependency injection (DI) works.
 * Car consit of wheels, seats, engine and steering wheel in this simple example.
 *
 * All used beans are declared in beans.xml
 */
public class SteeringWheel {

    private String brand;

    @Override
    public String toString() {
        return "SteeringWheel: " + brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
