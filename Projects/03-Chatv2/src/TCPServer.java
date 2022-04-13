import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main (String[] args) {
	try{
		int serverPort = 7896; 
		ServerSocket listenSocket = new ServerSocket(serverPort);
		System.out.println("The server is running on port " + serverPort + "\n");
		//System.out.println("Starting chat: " + "\n");
		while(true) {
			Socket clientSocket = listenSocket.accept();
			Connection c = new Connection(clientSocket); // To accept multiple clients

			// To send and receive how many messages you want
			Sender sender = new Sender(clientSocket);
			Receiver receiver = new Receiver(clientSocket);
			new Thread(sender); // A new thread do deal with out flow
			new Thread(receiver); // A new thread do deal with in flow
		}
	} catch(IOException e) {System.out.println("Listen :"+e.getMessage());}
    }
}
