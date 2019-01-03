package chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ReceiverImpl extends UnicastRemoteObject implements Receiver {
	ArrayList<String> listClients; 
	String pseudo;

	protected ReceiverImpl() throws RemoteException {
		super();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void receive(String from, String message) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(from+":"+message);
		
	}

	@Override
	public void initClient(ArrayList<String> client) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(client);
		
	}

	@Override
	public void addClient(String client) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initClient(String client) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<String> getListClients() {
		return listClients;
	}

	public void setListClients(ArrayList<String> listClients) {
		this.listClients = listClients;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) throws RemoteException {
		this.pseudo = pseudo;
	}

}
