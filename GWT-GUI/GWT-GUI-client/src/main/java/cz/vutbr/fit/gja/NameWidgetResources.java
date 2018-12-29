/*
 * ----------------------------------------------------------------------------
 * GWT GUI example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         NameWidgetResources.java
 * Description:  Resources for custom widget
 * ----------------------------------------------------------------------------
 */

package cz.vutbr.fit.gja;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;


/**
 * Resources for custom widget
 * Adapted from http://www.tutorialspoint.com/gwt/gwt_uibinder.htm
 */
public interface NameWidgetResources extends ClientBundle {

    /**
     * Sample CssResource.
     */
    interface MyCss extends CssResource {

        String box();

        String background();

        String greyText();
    }

    @Source("NameWidget.css")
    MyCss style();

    /*
     * We can add for example image resource and then use it in XML
     *
     * @Source("Logo.jpg")
     * ImageResource logo();
     */
}
