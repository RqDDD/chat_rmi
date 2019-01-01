package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Connection extends Remote { 
	public void connect(String pseudo ) throws RemoteException;
	public void disconnect(String pseudo ) throws RemoteException;
}
