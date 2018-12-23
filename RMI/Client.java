/*
 * ----------------------------------------------------------------------------
 * RMI example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         Client.java
 * Description:  Client calling method on server
 * ----------------------------------------------------------------------------
 */

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

/**
 * Simple RMI client usable from command line.
 * At first client finds stub for DeepThought in RMI Registry via JNDI and then it call its method with RPC.
 * Everything is synchrounous and looks like local method call.
 */
public class Client {

    /**
     * Main function
     *
     * @param args Command line arguments
     * @param args
     * @throws NotBoundException
     * @throws MalformedURLException
     * @throws RemoteException
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {

        // fing remote object in RMI Registry
        DeepThoughtInterface deepThought = (DeepThoughtInterface) Naming.lookup("//localhost/DeepThought");

        // remotely call method 
        String answer = deepThought.getAnswerToLifeTheUniversAndEverything();

        System.out.println("The answer to life, the universe and everything is: " + answer);

    }
}
