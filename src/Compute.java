import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {

	 long executeTask(Task t) throws RemoteException;
}
