package cz.vutbr.fit.bean.JSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.LinkedHashMap;
import java.util.Map;

@ManagedBean (name = "kalkulackaBean")
@RequestScoped
public class KalkulackaBean {
    private double cislo1;
    private double cislo2;
    private double vysledok;
    private String operacia;
    private Map<String, String> mozneOperacie;

    public KalkulackaBean() {
        mozneOperacie = new LinkedHashMap<>();
        mozneOperacie.put("Sčítaj", "+");
        mozneOperacie.put("Odčítaj", "-");
        mozneOperacie.put("Vynásob", "*");
        mozneOperacie.put("Vydel", "/");
    }

    public void vypocitaj()
    {
        switch (operacia)
        {
            case "+":
                vysledok = cislo1+ cislo2;
                break;
            case "-":
                vysledok = cislo1- cislo2;
                break;
            case "*":
                vysledok = cislo1* cislo2;
                break;
            case "/":
                vysledok = cislo1/ cislo2;
                break;
        }

    }

    // GETTERS
    public double getCislo1() {
        return cislo1;
    }

    public double getCislo2() {
        return cislo2;
    }

    public double getVysledok() {
        return vysledok;
    }

    public String getOperacia() {
        return operacia;
    }

    public Map<String, String> getMozneOperacie() {
        return mozneOperacie;
    }

    // SETTERS
    public void setCislo1(double cislo1) {
        this.cislo1 = cislo1;
    }

    public void setCislo2(double cislo2) {
        this.cislo2 = cislo2;
    }

    public void setOperacia(String operacia) {
        this.operacia = operacia;
    }
}
