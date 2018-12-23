package cz.vutbr.fit.bean.EJB.stateless;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Statless Java Bean implementujúci jednu metodu na výpočet ceny produktu s daňou.
 *
 * @author  Michal Gabonay
 * @version 1.0
 * @since   2018-12-16
 */
@Stateless (name = "Calculator")
@Remote (TaxCalculator.class)
public class TaxCalculatorImpl implements TaxCalculator {

    @Override
    public double addTaxToPrice(double price, double tax) {
        return price + (price*(tax/100));
    }
}
