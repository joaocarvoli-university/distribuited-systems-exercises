import java.net.*;
import java.io.*;
import ioflow.Input;
import ioflow.Output;

public class TCPClient {
	public static void main (String[] args) {
	Socket socket = null;
	    try{
	    	int serverPort = 7896;
		   	socket = new Socket(args[0], serverPort);
			System.out.println("Starting chat: " + "\n");

			Input input = new Input(socket, "B");
			Output output = new Output(socket);
			input.start();
			output.start();

	    } catch (UnknownHostException e){
			System.out.println("Sock:"+e.getMessage()); 
	    } catch (EOFException e){ 
			System.out.println("EOF:"+e.getMessage());
	    } catch (IOException e){ 
			System.out.println("IO:"+e.getMessage());
		}
  	}
}
