package cz.vutbr.fit.gja.spring.bean.xml;

/**
 * @author Martin Kocour
 * created on 22/12/2018
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
