package chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class EmitterImpl extends UnicastRemoteObject implements Emitter{
	
	String pseudo;

	protected EmitterImpl(String pseudo) throws RemoteException {
		super();
		this.pseudo = pseudo;
		// TODO Auto-generated constructor stub
	}

	public void sendMessage(String to, String message) {
		ArrayList<String> mess = new ArrayList<String>();
		mess.add(to);
		mess.add(message);
		Receiver myReceiver;
		try {
			myReceiver = new ReceiverImpl();
			myReceiver = (Receiver) Naming.lookup("Receiver_"+to);
			myReceiver.receive(pseudo, message);
		} catch (RemoteException  | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
