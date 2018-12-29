/*
 * ----------------------------------------------------------------------------
 * GWT RPC example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         DeepThoughtServiceInterfaceAsync.java
 * Description:  Asynchronous remote service interface
 * ----------------------------------------------------------------------------
 */

package cz.vutbr.fit.gja;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>DeepThoughtServiceInterface</code>.
 */
public interface DeepThoughtServiceInterfaceAsync {

    /**
     * Compute answer to life universe and everything
     */
    void getAnswerToLifeTheUniverseAndEverything(AsyncCallback<DeepThoughtResponse> callback);
}
