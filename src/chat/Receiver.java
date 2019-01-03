package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Receiver extends Remote{
	public void receive(String from, String message) throws RemoteException;
	public void initClient(ArrayList<String> client) throws RemoteException;
	public void addClient(String client) throws RemoteException;
	public void initClient(String client) throws RemoteException;
	public void setPseudo(String pseudo) throws RemoteException ;
}
