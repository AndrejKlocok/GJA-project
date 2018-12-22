/*
 * ----------------------------------------------------------------------------
 * RMI example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         DeepThoughtInterface.java
 * Description:  Remote interface
 * ----------------------------------------------------------------------------
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface
 */
public interface DeepThoughtInterface extends Remote {

    /**
     * Compute answer to life universe and everything
     *
     * @return answer to life universe and everything
     * @throws RemoteException
     */
    String getAnswerToLifeTheUniversAndEverything() throws RemoteException;
}
