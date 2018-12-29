package cz.vutbr.fit.gja.spring.bean.xml;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 *
 * This simple example demonstrates Singleton and Prototype scope.
 *
 * See beans.xml details.
 */
public class ScopeExample {
    private Integer counter = 0;
    private String name;

    public ScopeExample(String name) {
        this.name = name;
    }

    /**
     * Returns the counter and increase it.
     *
     * The counter is increased every time we accessed it.
     * @return The value of counter.
     */
    public Integer getCounter() {
        return counter++;
    }

    @Override
    public String toString() {
        return name + ": counter: " + getCounter();
    }
}
