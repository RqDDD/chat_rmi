package chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ClientManagerImpl extends UnicastRemoteObject implements ClientManager {
	String pseudo;
	protected ClientManagerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initClients(ArrayList<String> clients) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(clients+ "are connected");
		
	}

	@Override
	public void addClient(String client) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(client+ "is now connected");
		
	}

	@Override
	public void remClient(String client) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(client+ "is now disconnected");
		
	}

	public void setPseudo(String pseudo) {
		// TODO Auto-generated method stub
		this.pseudo = pseudo;
		
	}
	
	public String getPseudo() {
		// TODO Auto-generated method stub
		return(pseudo);
		
	}
}
