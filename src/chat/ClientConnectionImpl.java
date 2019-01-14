package chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientConnectionImpl extends UnicastRemoteObject implements ClientConnection{

	String pseudo;
	protected ClientConnectionImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public MessageBox connect(String pseudo, MessageBox rcv) throws RemoteException {
		// TODO Auto-generated method stub	
		MessageBox myMessageBox = null;
		try {	
			myMessageBox = new MessageBoxImpl(); 
			Naming.rebind("MessageBox_"+pseudo+"_", myMessageBox);
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myMessageBox;
	}

	@Override
	public void setPseudo(String pseudo) {
		// TODO Auto-generated method stub
		this.pseudo = pseudo;
		
	}
	
	public String getPseudo() {
		// TODO Auto-generated method stub
		return(pseudo);
		
	}

}
