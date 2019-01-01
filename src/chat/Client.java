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
	   String pseudo = null;
	   Dialogue myDialogue = null;
	   Connection myConnection = null;
	   try {
			
			myConnection = (Connection) Naming.lookup("Connection");
			System.out.println("Client connected\n\n");
			System.out.println("Several command available : \n");
			System.out.println("connect");
			System.out.println("disconnect");
			System.out.println("send");
			System.out.println("getC");
			System.out.println("getM");
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
			myConnection.connect(pseudo);
			try {
				myDialogue = (Dialogue) Naming.lookup("Dialogue_"+pseudo);
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(line.equals("disconnect")) {
			myConnection.disconnect(pseudo);
			session = "false";
		}
		
		else if(line.equals("send")) {
			Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.println("Enter your recipient: ");
			String to = reader.nextLine(); 
			System.out.println("Enter your message: ");
			String message = reader.nextLine(); 
			
			//reader.close();
			myDialogue.sendMessage(to, message);
			
		}
		
		else if(line.equals("getC")) {
			System.out.println(myDialogue.getClients());
			
		}
		
		else if(line.equals("getM")) {
			System.out.println(myDialogue.getMessages());
			
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
