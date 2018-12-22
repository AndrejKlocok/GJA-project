package cz.vutbr.fit.gja.spring.bean;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 */
public class ScopeExample {
    private Integer counter = 0;
    private String name;

    public ScopeExample(String name) {
        this.name = name;
    }

    public Integer getCounter() {
        return counter++;
    }

    @Override
    public String toString() {
        return name + ": counter: " + getCounter();
    }
}
