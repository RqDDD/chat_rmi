package chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Server {
	
	ArrayList<String> listClients; 
	// message : { pseudo recipient, pseudo recipient, message }
	ArrayList<ArrayList<String>> listMessages; // not the best way to store message...  could have used a map
	public Server() {
		this.listClients = new ArrayList();
		this.listMessages = new ArrayList();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		try {
			Connection myConnection = new ConnectionImpl(server);
			
			Naming.rebind("Connection", myConnection);
			
			System.out.println("Server online");
			
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> getListClients() {
		return listClients;
	}
	
	public ArrayList<ArrayList<String>> getListMessages() {
		return listMessages;
	}
	
	public ArrayList<ArrayList<String>> getMessagesForOne(String pseudo) {
		ArrayList<ArrayList<String>> messages = new ArrayList<ArrayList<String>>();
		System.out.println("1");
		try {
			
			for (ArrayList<String> mess : getListMessages()) {
				if (mess.get(1).equals(pseudo)) {
					messages.add(mess);
	
				}
			}
			if (messages.size() == 0){
				messages.add(new ArrayList<String>());
				messages.get(0).add("None");
				messages.get(0).add("You have no friend sorry !");
			}
		}
		catch(Exception e){
			System.out.println(" No message on the server ");
		}
		return messages;
	}
}
