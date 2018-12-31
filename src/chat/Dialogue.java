package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Dialogue extends Remote {
	
	public void connect(String pseudo ) throws RemoteException;
	public void disconnect(String pseudo ) throws RemoteException;
	public ArrayList<String> getClients() throws RemoteException;
	public void sendMessage(String from, String to, String message) throws RemoteException;
	public ArrayList<ArrayList<String>> getMessages(String pseudo) throws RemoteException;
}
