import java.rmi.*;

public interface AddServerIntf extends Remote {
	double add(double dl, double d2) throws RemoteException;
}