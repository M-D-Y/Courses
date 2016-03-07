package rmiserver;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class RMIServer implements Hello {
        
    public RMIServer() {}

    public String helloWorld() {
        return "Hello, world!";
    }
        
    public static void main(String args[]) {
        //if(System.getSecurityManager()==null){
        //    SecurityManager sm=new SecurityManager();
        //    System.setSecurityManager(sm);
        //}
        try {
            RMIServer obj = new RMIServer();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            //Registry registry = LocateRegistry.getRegistry();
            //Registry registry = LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.createRegistry(9090);
            //Registry registry = LocateRegistry.getRegistry("localhost", 1098);
            registry.rebind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

	@Override
	public String sayHello() throws RemoteException {
		return helloWorld();
	}
}
