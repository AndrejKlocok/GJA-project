package cz.vutbr.fit.bean.EJB.stateless;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 * Managed Bean pre použitie vloženia biznis logiky stateless beanu na výpočet daní do JSF.
 *
 * @author  Michal Gabonay
 * @version 1.0
 * @since   2018-12-16
 */
@ManagedBean (name = "TaxCalculatorBean")
public class TaxCalculatorBean {
    // anotáciou @EJB sa definuje Enterprise java bean ktorá je injectnutá do Managed Bean
    @EJB
    TaxCalculator taxCalculator;
    private double price;
    private double tax;
    private double result;

    public double getPrice() {
        return price;
    }

    public double getTax() {
        return tax;
    }

    public double getResult() {
        return result;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String addTaxToPrice() {
        result = taxCalculator.addTaxToPrice(price, tax);
        return "success";
    }

}
