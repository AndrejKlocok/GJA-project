/*
 * ----------------------------------------------------------------------------
 * GWT RPC example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         DeepThoughtServiceInterface.java
 * Description:  Remote service interface
 * ----------------------------------------------------------------------------
 */

package cz.vutbr.fit.gja;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("deep-thought")
public interface DeepThoughtServiceInterface extends RemoteService {

    /**
     * Compute answer to life universe and everything
     *
     * @return answer to life universe and everything
     */
    DeepThoughtResponse getAnswerToLifeTheUniverseAndEverything();
}
