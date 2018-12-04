package cz.vutbr.fit.bean.PrimeFaces;

import org.primefaces.event.RateEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "ValidationBean")
public class ValidationBean {
    @Size(min = 1, max = 10)
    private String field;
    @Min(0) @Max(100)
    private int intVal;
    @Digits(integer = 2, fraction = 2)
    private double percent;
    @Future
    private Date dateVal;
    @Pattern(regexp = "^x[a-z]{5}\\d{2}$")
    private String regex;
    @NotNull
    private Boolean radioBtn;

    private String autocomplete1;
    private String telephoneString;
    private Integer rating;

    private String colorInline;
    private int sliderNumber;


    public List<String> autoComplete(String text) {
        List<String> output = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            output.add(text + i);
        }
        return output;
    }

    public void onRate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onCancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onInputChanged(ValueChangeEvent event) {
        FacesMessage message = new FacesMessage("Input Changed", "Value: " + event.getNewValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public int getSliderNumber() {
        return sliderNumber;
    }

    public void setSliderNumber(int sliderNumber) {
        this.sliderNumber = sliderNumber;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTelephoneString() {
        return telephoneString;
    }

    public void setTelephoneString(String telephoneString) {
        this.telephoneString = telephoneString;
    }

    public String getAutocomplete1() {
        return autocomplete1;
    }

    public void setAutocomplete1(String autocomplete1) {
        this.autocomplete1 = autocomplete1;
    }

    public Boolean getRadioBtn() {
        return radioBtn;
    }

    public void setRadioBtn(Boolean radioBtn) {
        this.radioBtn = radioBtn;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public Date getDateVal() {
        return dateVal;
    }

    public void setDateVal(Date dateVal) {
        this.dateVal = dateVal;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getColorInline() {
        return colorInline;
    }

    public void setColorInline(String colorInline) {
        this.colorInline = colorInline;
    }
}
