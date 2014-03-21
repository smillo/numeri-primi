import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputePrime {
	public static void main(String args[]) {
		String host = (args.length < 1) ? null : args[0];
		long digits = (long) (Math.random()*100);
		try {
			String name = "Compute";
			Registry registry = LocateRegistry.getRegistry(host);
			Compute comp = (Compute) registry.lookup(name);

			PrimeNumber task = new PrimeNumber((long) digits);
			long prime = comp.executeTask(task);
			System.out.println("digiti " + digits +" e il primo numero primo  " + prime);
		} catch (Exception e) {
			System.err.println("ComputePrime exception :");
			e.printStackTrace();
		}
	}
}
