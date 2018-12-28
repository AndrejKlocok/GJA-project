package cz.vutbr.fit.gja.spring.bean.xml.di;

/**
 * @author Martin Kocour
 * created on 22/12/2018
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
