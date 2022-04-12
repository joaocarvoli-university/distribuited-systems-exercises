import java.net.*;
import java.io.*;
import java.io.BufferedReader;

public class TCPClient {
	public static void main (String[] args) {
	Socket s = null;
	BufferedReader br;
	Chat chat = new Chat();

	    try{
	    	int serverPort = 7896;
		   	s = new Socket(args[0], serverPort);
		   	//DataInputStream in = new DataInputStream(s.getInputStream());
			//DataOutputStream out = new DataOutputStream( s.getOutputStream());
			//br = new BufferedReader(new InputStreamReader(System.in));
			//chat.communication(in, out, br, "Client"); // Establishing connection

			System.out.println("Starting chat: " + "\n");
			Sender sender = new Sender(s);
			Receiver receiver = new Receiver(s);

			new Thread(sender);
			new Thread(receiver);
	    } catch (UnknownHostException e){
			System.out.println("Sock:"+e.getMessage()); 
	    } catch (EOFException e){ 
			System.out.println("EOF:"+e.getMessage());
	    } catch (IOException e){ 
			System.out.println("IO:"+e.getMessage());
		}
		finally { if(s!=null) { 
			try {
				 s.close();
				} 
			catch (IOException e)
				{
				System.out.println("close:"+e.getMessage()); 
				} 
			}
		}
  	}
}
