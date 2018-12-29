/*
 * ----------------------------------------------------------------------------
 * GWT RPC example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         DeepThoughtService.java
 * Description:  Implementation of remote service interface
 * ----------------------------------------------------------------------------
 */

package cz.vutbr.fit.gja;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
public class DeepThoughtService extends RemoteServiceServlet implements DeepThoughtServiceInterface {

    /**
     * Compute answer to life universe and everything
     *
     * @return answer to life universe and everything
     */
    public DeepThoughtResponse getAnswerToLifeTheUniverseAndEverything() {

        DeepThoughtResponse response = new DeepThoughtResponse();

        response.setResult("42");

        return response;
    }
}
