package chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue{
	Server server;
	
	protected DialogueImpl(Server server) throws RemoteException {
		super();
		this.server = server;
		// TODO Auto-generated constructor stub
	}
	
	public void connect(String pseudo ) {
		getServer().getListClients().add(pseudo); 
		
	}
	public void disconnect(String pseudo ) {
		int i = 0;
		while (i <= getClients().size() && getClients().get(i) != pseudo){
			i++;
			if (getClients().get(i) != pseudo) {
				getClients().remove(i);
			}
		}
	}
	
	public ArrayList<String> getClients() {
		// For now it will remain an ArrayList instead of a String[]
		return(getServer().getListClients());
		
	}
	
	public void sendMessage(String from, String to, String message) {
		ArrayList<String> mess = new ArrayList<String>();
		mess.add(from);
		mess.add(to);
		mess.add(message);
		getServer().listMessages.add(mess);
	}
	
	public ArrayList<ArrayList<String>> getMessages(String pseudo) {
		return(getServer().getMessagesForOne(pseudo));
		
	}

	public Server getServer() {
		return server;
	}
	
	
	
}
