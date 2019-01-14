package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientConnection  extends Remote{
	public MessageBox connect(String pseudo, MessageBox rcv) throws RemoteException;

	public void setPseudo(String pseudo) throws RemoteException;
}
