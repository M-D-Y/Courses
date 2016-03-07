import java.rmi.*;
import java.rmi.server.*;


public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf {
	public AddServerImpl() throws RemoteException {
	}

	public double add(double dl, double d2) throws RemoteException {
		return dl + d2;
	}
}