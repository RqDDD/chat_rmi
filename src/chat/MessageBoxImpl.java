package chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MessageBoxImpl extends UnicastRemoteObject implements MessageBox{
	String pseudo;
	String to;
	protected MessageBoxImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void receive(String message) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(to + " " + "you received from "+ pseudo + " :" + message);
		
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
