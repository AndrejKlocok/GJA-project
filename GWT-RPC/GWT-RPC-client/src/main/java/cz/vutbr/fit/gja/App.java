/*
 * ----------------------------------------------------------------------------
 * GWT RPC example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         App.java
 * Description:  App entry point
 * ----------------------------------------------------------------------------
 */

package cz.vutbr.fit.gja;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


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
     * Create a remote service proxy to talk to the server-side.
     */
    private final DeepThoughtServiceInterfaceAsync deepThoughtService = GWT.create(DeepThoughtServiceInterface.class);

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        // Create dialog button which opens dialog
        final Button dialogButton = new Button("Compute answer to life universe and everything");
        dialogButton.setFocus(true);

        // Create the popup dialog box
        final DialogBox dialogBox = new DialogBox();
        dialogBox.setText("Remote Procedure Call");
        dialogBox.setAnimationEnabled(true);

        // Response from server in dialog
        final HTML serverResponseLabel = new HTML();

        // Create close button, later we will add it to dialog box
        final Button closeButton = new Button("Close");

        // Add a handler to close the DialogBox
        closeButton.addClickHandler(event -> {
            dialogBox.hide();
            dialogButton.setEnabled(true);
            dialogButton.setFocus(true);
        });

        // Add handler to compute button
        dialogButton.addClickHandler(event -> {
            dialogBox.center();
            dialogButton.setEnabled(false);
            // RPC usage
            deepThoughtService.getAnswerToLifeTheUniverseAndEverything(new AsyncCallback<DeepThoughtResponse>() {
                public void onFailure(Throwable caught) {
                    // Show the RPC error message to the user
                    dialogBox.setText("Remote Procedure Call - Failure");
                    serverResponseLabel.addStyleName("serverResponseLabelError");
                    serverResponseLabel.setHTML(SERVER_ERROR);
                    dialogBox.center();
                    closeButton.setFocus(true);
                }

                public void onSuccess(DeepThoughtResponse response) {
                    dialogBox.setText("Remote Procedure Call");
                    serverResponseLabel.removeStyleName("serverResponseLabelError");
                    serverResponseLabel.setHTML(response.getResult());
                    dialogBox.center();
                    closeButton.setFocus(true);
                }
            });
        });

        // Dialog content structure
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.add(new HTML("<b>Answer to life universe and everything is: </b>"));
        dialogVPanel.add(new HTML("<br>"));
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        dialogBox.setWidget(dialogVPanel);

        // Use RootPanel.get() to get the entire body element
        RootPanel rootPanel = RootPanel.get("mainContainer");
        rootPanel.add(dialogButton);
    }
}
