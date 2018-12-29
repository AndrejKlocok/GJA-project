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
public class AirCondition {
    private int temp = 0;

    public void setTemperature(int temperature) {
        temp = temperature;
        System.out.println("Temp " + temperature + "C");
    }

    public int getTemp() {
        return temp;
    }
}
