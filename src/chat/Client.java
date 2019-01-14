package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
	
	
	

	public static void main(String[] args) {
	   System.out.println("Client launching...");
	   String session = "true";
	   String connectionStatus = "false";
	   String pseudo = null;
	   ServerConnection myServerConnection = null;
	   ClientConnection myClientConnection = null;
	   ClientManager myClientManager = null;
	   MessageBox myMessageBox = null;
	   MessageBox hisMessageBox = null;
	   try {
		   
		   myClientConnection = new ClientConnectionImpl();	
		   myClientManager = new ClientManagerImpl();
		   
			
			
		    myServerConnection = (ServerConnection) Naming.lookup("ServerConnection");
			System.out.println("Client connected\n\n");
			System.out.println("Several commands available : \n");
			System.out.println("connectS");
			System.out.println("disconnect");
			System.out.println("getC");
			System.out.println("connectC");
			System.out.println("send");

	   } catch (MalformedURLException | RemoteException | NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   String line = "";
	   while (session.equals("true")) {
	       try {
			line = in.readLine();
			
		if(line.equals("connectS")) {
			//connect to server
			Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.println("Enter your pseudo: ");
			pseudo = reader.nextLine(); 
			
			myServerConnection.connect(pseudo, myClientConnection, myClientManager);
			
			//reader.close();
			myClientConnection.setPseudo(pseudo);
			myClientManager.setPseudo(pseudo);
			
		
				Naming.rebind("ClientConnection_"+pseudo, myClientConnection);
				Naming.rebind("ClientManager_"+pseudo, myClientConnection);
				connectionStatus = "true";
	
			}
		
		else if(line.equals("disconnect")) {
			if (connectionStatus == "true") {
				myServerConnection.disconnect(pseudo);
				session = "false";
				connectionStatus = "false";
			}
			else {
				System.out.println("Please connect first");
			}

		}
		
		else if(line.equals("getC")) {
			if (connectionStatus == "true") {
				Scanner reader = new Scanner(System.in);  // Reading from System.in
				System.out.println("Enter your recipient: ");
				String to = reader.nextLine(); 

				myServerConnection.getClient(to);
				// Receiver messagebox
				hisMessageBox = new MessageBoxImpl();			
				Naming.rebind("MessageBox_"+to+"_"+pseudo, hisMessageBox);
				hisMessageBox.setPseudo(pseudo);
				hisMessageBox.setTo(to);
				
				myMessageBox = myClientConnection.connect(pseudo, hisMessageBox);
				myMessageBox.setPseudo(to);
				myMessageBox.setTo(pseudo);
			}
			else {
				System.out.println("Please connect first");
			}

		}
		

		
		else if(line.equals("send")) {
			if (connectionStatus == "true") {
				Scanner reader = new Scanner(System.in);  // Reading from System.in
				System.out.println("Enter your recipient: ");
				String to = reader.nextLine(); 
				System.out.println("Enter your message: ");
				String message = reader.nextLine(); 
				
				try {
					MessageBox aMessageBox = (MessageBox) Naming.lookup("MessageBox_"+to+"_"+pseudo);
					aMessageBox.receive(message);
				}
				catch(Exception e) {
					
				}
				//reader.close();
				
			}
			else {
				System.out.println("Please connect first");
			}
			
		}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	       //do something
	   }
	    
	   
	   System.out.println("Client end");
	  }
}
