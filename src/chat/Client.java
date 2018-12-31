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
	   System.out.println("Lancement du client");
	   String session = "true";
	   String pseudo = null;
	   Dialogue myDialogue = null;
	   try {
			myDialogue = (Dialogue) Naming.lookup("Dialogue");
			System.out.println(myDialogue.getClients());
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
			myDialogue.connect(pseudo);
		}
		else if(line.equals("disconnect")) {
			myDialogue.disconnect(pseudo);
			session = "false";
		}
		
		else if(line.equals("send")) {
			Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.println("Enter your recipient: ");
			String to = reader.nextLine(); 
			System.out.println("Enter your message: ");
			String message = reader.nextLine(); 
			
			//reader.close();
			myDialogue.sendMessage(pseudo, to, message);
			
		}
		
		else if(line.equals("getC")) {
			System.out.println(myDialogue.getClients());
			
		}
		
		else if(line.equals("getM")) {
			System.out.println(myDialogue.getMessages(pseudo));
			
		}
		
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	       //do something
	   }
	    
	   
	   System.out.println("Fin du client");
	  }
}
