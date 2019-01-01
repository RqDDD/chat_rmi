package chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue{
	Server server;
	String pseudo;
	
	protected DialogueImpl(Server server, String pseudo) throws RemoteException {
		super();
		this.server = server;
		this.pseudo = pseudo;
		// TODO Auto-generated constructor stub
	}
	

	
	public ArrayList<String> getClients() {
		// For now it will remain an ArrayList instead of a String[]
		return(getServer().getListClients());
		
	}
	
	public void sendMessage(String to, String message) {
		ArrayList<String> mess = new ArrayList<String>();
		mess.add(this.pseudo);
		mess.add(to);
		mess.add(message);
		getServer().listMessages.add(mess);
	}
	
	public ArrayList<ArrayList<String>> getMessages() {
		return(getServer().getMessagesForOne(this.pseudo));
		
	}

	public Server getServer() {
		return server;
	}
	
	
	
}
