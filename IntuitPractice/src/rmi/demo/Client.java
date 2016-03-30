package rmi.demo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

	String host = (args.length < 1) ? null : args[0];
	try {
	   Registry registry;
		// Registry registry = LocateRegistry.createRegistry(7777);
	    //if (null == registry) 
	    	registry = LocateRegistry.getRegistry();
	    Hello stub = (Hello) registry.lookup("Hello");
	    System.out.println(stub);

	    String response = stub.sayHello();
	    System.out.println("response: " + response);
	} catch (Exception e) {
	    System.err.println("Client exception: " + e.toString());
	    e.printStackTrace();
	}
    }
}