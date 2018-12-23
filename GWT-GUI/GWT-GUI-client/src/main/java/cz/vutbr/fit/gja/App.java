/*
 * ----------------------------------------------------------------------------
 * GWT GUI example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         App.java
 * Description:  App entry point
 * ----------------------------------------------------------------------------
 */

package cz.vutbr.fit.gja;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.util.Date;


/**
 * App entry point.
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {

    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {


        // Buttons

        final Button button = new Button("Button");

        // We can add style names to widgets
        final Button blueButton = new Button("Blue button");
        blueButton.addStyleName("BackgroundBlue");

        // We can set the id of a widget by accessing its Element
        final Button greenButton = new Button("Green button");
        greenButton.getElement().setId("greenButton");

        FlowPanel buttonsFlowPanel = new FlowPanel();
        buttonsFlowPanel.add(button);
        buttonsFlowPanel.add(blueButton);
        buttonsFlowPanel.add(greenButton);

        final PushButton pushButton = new PushButton("Push button");
        final ToggleButton toggleButton = new ToggleButton("Toggle button");
        final CheckBox checkBox = new CheckBox("Checkbox");
        final RadioButton radioButton = new RadioButton("Radio button");


        // Fields

        final TextBox textField = new TextBox();
        final PasswordTextBox passwordField = new PasswordTextBox();
        final TextArea textArea = new TextArea();


        // Date picker

        // Create a basic date picker
        DatePicker datePicker = new DatePicker();

        // Set the default value
        datePicker.setValue(new Date());

        // Create a DateBox
        DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
        DateBox dateBox = new DateBox();
        dateBox.setFormat(new DateBox.DefaultFormat(dateFormat));

        Label selectLabel = new Label("Permanent DatePicker:");
        Label selectLabel2 = new Label("DateBox with popup DatePicker:");

        // Add widgets to the panel.
        FlowPanel datePickerFlowPanel = new FlowPanel();
        datePickerFlowPanel.add(selectLabel);
        datePickerFlowPanel.add(datePicker);
        datePickerFlowPanel.add(selectLabel2);
        datePickerFlowPanel.add(dateBox);

        // Labels

        Label label = new Label("This is GWT Label");


        // HTML
        HTML html = new HTML("This is <b>HTML</b> widget using <i>tag of html</i>.");


        // Image

        // Create a Image widget
        Image image = new Image();

        //set image source
        image.setUrl("http://www.fit.vutbr.cz/images/fitnew.png");


        // Links

        // Create a Anchor widget,
        // pass text as VUT FIT
        // set asHtml as false,
        // href as www.fit.vutbr.cz,
        // target as _blank
        Anchor anchor = new Anchor("VUT FIT",
                false,
                "http://www.fit.vutbr.cz",
                "_blank");


        // Dialog popup

        // Create the popup dialog box
        final DialogBox dialogBox = new DialogBox();
        dialogBox.setText("Dialog box text");
        dialogBox.setAnimationEnabled(true);

        // Create dialog button which opens dialog
        final Button dialogButton = new Button("Open dialog popup");
        dialogButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dialogBox.center();
                dialogButton.setEnabled(false);
            }
        });

        // Create close button, later we will add it to dialog box
        final Button closeButton = new Button("Close");

        // Add a handler to close the DialogBox
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dialogBox.hide();
                dialogButton.setEnabled(true);
            }
        });

        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.add(new HTML("<b>Message</b>"));
        dialogVPanel.add(new HTML("<br>Lorem ipsum dolor sit amet, consectetuer adipiscing elit."));
        dialogVPanel.add(new HTML("<br>Maecenas fermentum, sem in pharetra pellentesque, velit turpis volutpat ante, in pharetra metus odio a lectus."));
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        dialogBox.setWidget(dialogVPanel);


        // Add components to RootPanel

        // Use RootPanel.get() to get the entire body element
        RootPanel rootPanel = RootPanel.get("mainContainer");

        // Add labels to the vertical panel.
        VerticalPanel leftVerticalPanel = new VerticalPanel();
        leftVerticalPanel.setSpacing(10);
        HTML leftHeading= new HTML();
        leftHeading.setHTML("<h1>Přehled základních widgetů</h1>");
        leftVerticalPanel.add(leftHeading);
        leftVerticalPanel.add(buttonsFlowPanel);
        leftVerticalPanel.add(pushButton);
        leftVerticalPanel.add(toggleButton);
        leftVerticalPanel.add(checkBox);
        leftVerticalPanel.add(radioButton);
        leftVerticalPanel.add(textField);
        leftVerticalPanel.add(passwordField);
        leftVerticalPanel.add(textArea);
        leftVerticalPanel.add(datePickerFlowPanel);
        leftVerticalPanel.add(label);
        leftVerticalPanel.add(html);
        leftVerticalPanel.add(image);
        leftVerticalPanel.add(anchor);
        leftVerticalPanel.add(dialogButton);

        // Add custom widget with UI Binder to second vertical panel
        VerticalPanel rightVerticalPanel = new VerticalPanel();
        rightVerticalPanel.setSpacing(10);
        HTML rightHeading= new HTML();
        rightHeading.setHTML("<h1>Vlastní widget pomocí UI Binder</h1>");
        rightVerticalPanel.add(rightHeading);
        rightVerticalPanel.add(new NameWidget());

        // Add both vertical panels next to each other
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(leftVerticalPanel);
        horizontalPanel.add(rightVerticalPanel);

        // Add all to root panel
        rootPanel.add(horizontalPanel);
    }
}
