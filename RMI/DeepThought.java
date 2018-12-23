/*
 * ----------------------------------------------------------------------------
 * RMI example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         DeepThought.java
 * Description:  Implementation of remote interface
 * ----------------------------------------------------------------------------
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Remote interface implementation.
 * This is defintion of what server return, when client invoke methods on DeepThoughtInterface.
 */
public class DeepThought extends UnicastRemoteObject implements DeepThoughtInterface {

    public DeepThought() throws RemoteException {
        super();
    }

    /**
     * Compute answer to life universe and everything
     *
     * @return answer to life universe and everything
     */
    public String getAnswerToLifeTheUniversAndEverything() {

        return "42";
    }
}
