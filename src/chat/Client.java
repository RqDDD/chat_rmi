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
	   Connection myConnection = null;
	   Receiver myReceiver = null;
	   Emitter myEmitter = null;
	   try {
		   
			myReceiver = new ReceiverImpl();		
			
			
			myConnection = (Connection) Naming.lookup("Connection");
			System.out.println("Client connected\n\n");
			System.out.println("Several commands available : \n");
			System.out.println("connect");
			System.out.println("disconnect");
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
			
		if(line.equals("connect")) {
			Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.println("Enter your pseudo: ");
			pseudo = reader.nextLine(); 
			
			//reader.close();
			myReceiver.setPseudo(pseudo);
			myEmitter = myConnection.connect(pseudo, myReceiver);
		
				Naming.rebind("Receiver_"+pseudo, myReceiver);
				connectionStatus = "true";
	
			}
		
		else if(line.equals("disconnect")) {
			if (connectionStatus == "true") {
				myConnection.disconnect(pseudo);
				session = "false";
				connectionStatus = "false";
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
				
				//reader.close();
				myEmitter.sendMessage(to, message);
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
