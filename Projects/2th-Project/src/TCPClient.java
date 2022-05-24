import java.net.*;
import java.io.*;
import java.io.BufferedReader;

public class TCPClient {
	public static void main (String[] args) {
	Socket s = null;
	BufferedReader br = null;
	ReadData data = new ReadData();

	    try{
	    	int serverPort = 7896;
		   	s = new Socket(args[0], serverPort);
		   	DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream( s.getOutputStream());

			data.clientReader(in, out, br); // Establishing connection
			
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
