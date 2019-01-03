package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Connection extends Remote { 
	public Emitter connect(String pseudo, Receiver rcv ) throws RemoteException;
	public void disconnect(String pseudo ) throws RemoteException;
}
