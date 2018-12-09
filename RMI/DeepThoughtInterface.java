import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface
 */
public interface DeepThoughtInterface extends Remote {

    String getAnswerToLifeTheUniversAndEverything() throws RemoteException;
}
