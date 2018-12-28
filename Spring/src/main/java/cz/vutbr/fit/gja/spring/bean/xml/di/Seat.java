package cz.vutbr.fit.gja.spring.bean.xml.di;

import cz.vutbr.fit.gja.spring.bean.xml.di.AirCondition;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 */
public class Seat {
    private String name;
    private AirCondition airConditionControl;

    public Seat(String name, AirCondition airConditionControl) {
        this.name = name;
        this.airConditionControl = airConditionControl;
    }

    public void controlHeater(int level) {
        System.out.print(name + " controlHeater");
        switch (level) {
            case 1:
                airConditionControl.setTemperature(18);
                break;
            case 2:
                airConditionControl.setTemperature(20);
                break;
            case 3:
                airConditionControl.setTemperature(22);
                break;
            case 4:
                airConditionControl.setTemperature(24);
                break;
            case 5:
                airConditionControl.setTemperature(26);
                break;
            default:
                airConditionControl.setTemperature(16);
                break;
        }
    }

    @Override
    public String toString() {
        if (airConditionControl != null) {
            return "Seat: " + name + "\n\t\tAC temp: " + airConditionControl.getTemp() + "C";
        } else {
            return "Seat: " + name;
        }
    }
}
