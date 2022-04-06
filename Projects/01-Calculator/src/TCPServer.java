import java.net.*;
import java.io.*;
import Data.DataHandling;
import Calculator.Calculator;
import Data.DataHandling;


public class TCPServer {
    public static void main (String[] args) {
	try{
		int serverPort = 7896; 
		ServerSocket listenSocket = new ServerSocket(serverPort); // Creating the socket and bounding to the port passed
		while(true) {
			Socket clientSocket = listenSocket.accept(); // This method blocks the connection until a request comes (Waits for a connection)
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
	public Connection (Socket aClientSocket) {
	    try {
			clientSocket = aClientSocket;
			in = new DataInputStream(clientSocket.getInputStream()); // input data stream
			out = new DataOutputStream(clientSocket.getOutputStream()); // output data stream
	     } catch(IOException e)  {System.out.println("Connection:"+e.getMessage());}
	}
	public void run(){
	    try {			                 // an echo server
	    	String data = in.readUTF();
			DataHandling dataHandled = new DataHandling();
			Calculator calc = new Calculator();
			float result = calc.doCalc(dataHandled.getValues(data)[0], dataHandled.getValues(data)[1], dataHandled.getOperator(data));
			out.writeUTF(String.valueOf(result));
	    } catch(EOFException e) {System.out.println("EOF:"+e.getMessage());
	    } catch(IOException e) {System.out.println("IO:"+e.getMessage());
	    } finally{
			try {
				clientSocket.close();
			}catch (IOException e){/*close failed*/}}
	}
}