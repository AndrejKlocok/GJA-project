package cz.vutbr.fit.bean.EJB.stateless;


import javax.ejb.Remote;

@Remote
public interface TaxCalculator {
    public double addTaxToPrice(double price, double tax);
}
