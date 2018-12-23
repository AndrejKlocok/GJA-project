/*
 * ----------------------------------------------------------------------------
 * GWT GUI example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         NameWidget.java
 * Description:  Custom widget with UI Binder
 * ----------------------------------------------------------------------------
 */

package cz.vutbr.fit.gja;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


/**
 * Custom widget with UI Binder
 * Adapted from http://www.tutorialspoint.com/gwt/gwt_uibinder.htm
 */
public class NameWidget extends Composite {

    private static NameWidgetUiBinder uiBinder = GWT.create(NameWidgetUiBinder.class);

    /*
     * @UiTemplate is not mandatory but allows multiple XML templates to be used
     * for the same widget. Default file loaded will be <class-name>.ui.xml
     */
    @UiTemplate("NameWidget.ui.xml")
    interface NameWidgetUiBinder extends UiBinder<Widget, NameWidget> {
    }

    @UiField(provided = true)
    final NameWidgetResources res;

    public NameWidget() {
        // Attach an external Resources (CSS)
        this.res = GWT.create(NameWidgetResources.class);
        res.style().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    TextBox nameField;

    @UiField
    Label responseLabel;

    /**
     * Key up event handler for name field
     *
     * @param event
     */
    @UiHandler("nameField")
    void handleNameFieldChange(KeyUpEvent event) {
        if (!nameField.getText().isEmpty()) {
            responseLabel.setText("Hello " + nameField.getText());
        } else {
            responseLabel.setText("");
        }
    }
}
