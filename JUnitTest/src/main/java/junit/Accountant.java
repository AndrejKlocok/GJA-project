package junit;

/**
 * Ukážkový príklad pre JUnit testovanie,
 * príklad nejakej triedy ktorá obsahujuca matematicke operacie.
 *
 * @author  Michal Gabonay
 * @version 1.0
 * @since   2018-12-20
 */
public class Accountant {

    private double income;

    // constructor
    public Accountant(double income) {
        this.income = income;
    }

    // getter
    public double getIncome() {
        return income;
    }

    // setter
    public void setIncome(double income) {
        this.income = income;
    }

    // výpočet daňe z výplaty
    public double getTaxFromIncome(){
        return this.income*0.21;
    }

    // výpočet nového platu
    public double countNewIncome(double rise_ratio, int rating, int worked_years){

        if (worked_years > 15){
            rise_ratio *= 1.5;
        } else if (worked_years > 10){
            rise_ratio *= 1.3;
        }
        double rise = this.income*rise_ratio + rating*50;

        rise = Math.round(rise * 100.0) / 100.0;

        return rise;

    }

    // výpočet bonusu k výplate
    public double getBonus(double bonus_ratio){
        return this.income*bonus_ratio;
    }
}
