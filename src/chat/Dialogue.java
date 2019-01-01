package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Dialogue extends Remote {
	

	public ArrayList<String> getClients() throws RemoteException;
	public void sendMessage(String to, String message) throws RemoteException;
	public ArrayList<ArrayList<String>> getMessages() throws RemoteException;
}
