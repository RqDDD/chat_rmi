package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerConnection extends Remote { 
	public void connect(String pseudo, ClientConnection cnx, ClientManager mgr ) throws RemoteException;
	public void disconnect(String pseudo ) throws RemoteException;
	public ClientConnection getClient(String pseudo) throws RemoteException;
}