package cz.vutbr.fit.bean.EJB.stateless;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless (name = "Calculator")
@Remote (TaxCalculator.class)
public class TaxCalculatorImpl implements TaxCalculator {

    @Override
    public double addTaxToPrice(double price, double tax) {
        return price + (price*(tax/100));
    }
}
