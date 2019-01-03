package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Emitter extends Remote{
	public void sendMessage(String to, String message) throws RemoteException;

}
