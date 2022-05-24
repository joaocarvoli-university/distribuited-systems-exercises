import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main (String[] args) {
	try{
		int serverPort = 7896; 
		ServerSocket listenSocket = new ServerSocket(serverPort);
		System.out.println("The server is running on port " + serverPort);
		while(true) {
			Socket clientSocket = listenSocket.accept();
			Connection c = new Connection(clientSocket);
			c.start();
		}
	} catch(IOException e) {System.out.println("Listen :"+e.getMessage());}
    }
}

class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	BufferedReader br = null;
	ReadData data = new ReadData();

	public Connection (Socket aClientSocket) {
	    try {
			clientSocket = aClientSocket;
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
	    } catch(IOException e){
			 System.out.println("Connection:"+e.getMessage());
		 	}
	}
	public void run(){
	    try {
			data.serverReader(in, out, br); // Establishing connection

	    } catch(EOFException e){
			System.out.println("EOF:"+e.getMessage());
	    } catch(IOException e){
			System.out.println("IO:"+e.getMessage());
	    } finally{ 
			try{
				clientSocket.close();
			}catch (IOException e){
				/*close failed*/
			}
		}
	}
}