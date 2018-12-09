import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

/**
 * Client
 */
public class Client {

    /**
     * Main function
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {

        // fing remote object in RMI Registry
        DeepThoughtInterface deepThought = (DeepThoughtInterface) Naming.lookup("//localhost/DeepThought");

        // remotely call method 
        String answer = deepThought.getAnswerToLifeTheUniversAndEverything();

        System.out.println("The answer to life, the universe and everything is: " + answer);

    }
}
