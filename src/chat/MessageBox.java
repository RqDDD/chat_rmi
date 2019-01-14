package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageBox  extends Remote{
	public void receive(String message) throws RemoteException;
	public void setPseudo(String pseudo) throws RemoteException;
	public void setTo(String pseudo) throws RemoteException;
}
