import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Remote interface implementation
 */
public class DeepThought extends UnicastRemoteObject implements DeepThoughtInterface {

    public DeepThought() throws RemoteException {
        super();
    }

    public String getAnswerToLifeTheUniversAndEverything() {

        return "42";
    }
}
