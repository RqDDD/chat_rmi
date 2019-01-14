package chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerConnectionImpl extends UnicastRemoteObject implements ServerConnection{
	Server server;
	
	protected ServerConnectionImpl(Server server) throws RemoteException {
		super();
		this.server = server;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void connect(String pseudo, ClientConnection cnx, ClientManager mgr) throws RemoteException {
		// TODO Auto-generated method stub
		
		//add new for every client
		for(ClientManager cm : getServer().getListCM()) {
			cm.addClient(pseudo);
		}
		
		getServer().getListClients().add(pseudo); 
		getServer().getListCC().add(cnx); 
		getServer().getListCM().add(mgr); 
		mgr.initClients(getServer().getListClients());

	}
	@Override
	public void disconnect(String pseudo) throws RemoteException {
		// TODO Auto-generated method stub
		
		//remove for every client
		for(ClientManager cm : getServer().getListCM()) {
			cm.remClient(pseudo);
		}
		
		int i = 0;
		try {
			Naming.unbind("ClientConnection"+"_"+pseudo);
			Naming.unbind("ClientManager"+"_"+pseudo);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (i <= getServer().getListClients().size() && getServer().getListClients().get(i) != pseudo){
			i++;
			if (getServer().getListClients().get(i) != pseudo) {
				getServer().getListClients().remove(i);
				getServer().getListCC().remove(i);
				getServer().getListCM().remove(i);
			}
		}
		
	}
	@Override
	public ClientConnection getClient(String pseudo) throws RemoteException {
		// TODO Auto-generated method stub
		ClientConnection target=null;
		int i = 0;
		if (getServer().getListClients().get(0).equals(pseudo)) {
			target = getServer().getListCC().get(0);
		}
		System.out.println(getServer().getListClients());
		while (i < getServer().getListClients().size() && !(getServer().getListClients().get(i).equals(pseudo))){
			System.out.println(pseudo+" "+ getServer().getListClients().get(i));
			System.out.println(!(getServer().getListClients().get(i).equals(pseudo)));
			if (getServer().getListClients().get(i).equals(pseudo)) {
				target = getServer().getListCC().get(i);
			}
			i++;
		}
		return(target);
	}
	
	public Server getServer() {
		return server;
	}
	
	
	
}
