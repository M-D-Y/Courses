import java.rmi.*;

public class AddClient {
	public static void main(String args[]) {
		String[] params = { "127.0.0.1", "2.3234", "78.3434"};
		for (int i = 0; i<args.length; i++) params[i] = args[i];
		try {
			String addServerURL = "rmi://" + params[0] + "/AddServer";
			AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);
			System.out.println("Пepвoe число: " + params[1]);
			double dl = Double.valueOf(params[1]).doubleValue();
			System.out.println("Bтopoe число: " + params[2]);
			double d2 = Double.valueOf(params[2]).doubleValue();
			System.out.println("Cyммa: " + addServerIntf.add(dl, d2));
		} catch (Exception е) {
			System.out.println("Иcключeниe: " + е);
		}
	}
}