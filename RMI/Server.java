/*
 * ----------------------------------------------------------------------------
 * RMI example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         Server.java
 * Description:  Server responding to client
 * ----------------------------------------------------------------------------
 */

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

/**
 * Server respoinding to clients.
 * It just registers remote object in RMI Registry and wait for clients.
 */
public class Server {

    /**
     * Main function
     *
     * @param args Command line arguments
     * @param args
     * @throws RemoteException
     * @throws MalformedURLException
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException {

        // we can install security manager
        // If an RMI program does not install a security manager, RMI will not download classes 
        // (other than from the local class path) for objects received as arguments or return values of 
        // remote method invocations.
        /*
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        */

        try {

            // create remote object instance
            DeepThought deepThought = new DeepThought();

            // bind remote object instance of to RMI Registry
            Naming.rebind("DeepThought", deepThought);

            System.out.println("Server is ready");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
