package cz.vutbr.fit.bean.EJB.stateless;


import javax.ejb.Remote;

/**
 * Remote interface pre stateless Java Bean, na výpočet daní.
 *
 * @author  Michal Gabonay
 * @version 1.0
 * @since   2018-12-16
 */
@Remote
public interface TaxCalculator {
    public double addTaxToPrice(double price, double tax);
}
