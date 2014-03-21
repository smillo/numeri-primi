import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine implements Compute {
	public ComputeEngine() {
		super();
	}

	public long executeTask(Task t) {
		return t.execute();
	}

	public static void main(String[] args) {
		try {
			String name = "Compute";
			Compute engine = new ComputeEngine();
			Compute stub = (Compute) UnicastRemoteObject
					.exportObject(engine, 0);
			// per semplicita ’ potete creare un Registry direttamente sulla
			// stessa JVM
			Registry registry = LocateRegistry.createRegistry(1099);
			// oppure dire ad rmiregistry dove sono le classi usando CLASSPATH
			// Registry registry = LocateRegistry . getRegistry () ;
			registry.rebind(name, stub);
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception :");
			e.printStackTrace();
		}
	}
}
