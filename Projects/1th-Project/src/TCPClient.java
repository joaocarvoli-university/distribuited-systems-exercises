import java.net.*;
import java.io.*;
public class TCPClient {
	public static void main (String[] args) {
	// arguments supply message and hostname of destination
	Socket s = null;
	    try{
	    	int serverPort = 7896;
		   	s = new Socket(args[1], serverPort); // connect()
			   // Creating socket to connect with another machine && Passing through args[1] the host of the app
		   	DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF(args[0]);        	// UTF is a string encoding see Sn 4.3 - send()
			String data = in.readUTF();	    // receive()
			System.out.println("The result of your operation is: "+ data);
	    } catch (UnknownHostException e){System.out.println("Sock:"+e.getMessage()); 
	    } catch (EOFException e){ System.out.println("EOF:"+e.getMessage());
	    } catch (IOException e){ System.out.println("IO:"+e.getMessage());
		} finally { if(s!=null) { try { s.close(); } catch (IOException e){System.out.println("close:"+e.getMessage()); } }
		}
  	}
}
