package chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ConnectionImpl extends UnicastRemoteObject implements Connection{
	Server server;
	protected ConnectionImpl(Server server) throws RemoteException {
		super();
		this.server = server;
		// TODO Auto-generated constructor stub
	}
	
	public void connect(String pseudo ) {
		getServer().getListClients().add(pseudo); 
		try {
			Dialogue myDialogue = new DialogueImpl(server, pseudo);		
			Naming.rebind("Dialogue_"+pseudo, myDialogue);
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void disconnect(String pseudo ) {
		int i = 0;
		try {
			Naming.unbind("Connection"+"_"+pseudo);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (i <= getServer().getListClients().size() && getServer().getListClients().get(i) != pseudo){
			i++;
			if (getServer().getListClients().get(i) != pseudo) {
				getServer().getListClients().remove(i);
			}
		}
	}

	public Server getServer() {
		return server;
	}
	
}
