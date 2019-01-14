package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ClientManager extends Remote {
	public void initClients(ArrayList<String> clients) throws RemoteException;
	public void addClient(String client) throws RemoteException;
	public void remClient(String client) throws RemoteException;
	public void setPseudo(String pseudo) throws RemoteException;
}
