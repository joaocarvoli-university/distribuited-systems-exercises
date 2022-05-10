package src.tcp;

import java.net.*;
import java.io.*;
import src.flow.*;


public class TCPClient {
	String serverAddress;
	String message;
	int service;
	public TCPClient(String newMessage, String newServerAddress, int serviceId){
		serverAddress = newServerAddress;
		message = newMessage;
		service = serviceId;
	}
	public void execute(){
		Socket s = null;
		{ try{
			int serverPort = 7896;
			try {
				s = new Socket(serverAddress, serverPort);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

			Dispatcher dispatcher;
			try {
				dispatcher = new Dispatcher(s);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			dispatcher.sendRequest(message + "," + service);
			//System.out.println("The result of your operation is: "+ dispatcher.getResponse());

		} catch (UnknownHostException e){System.out.println("Sock Client:"+e.getMessage());
		} catch (EOFException e){ System.out.println("EOF Client:"+e.getMessage());
		} catch (IOException e){ System.out.println("IO Client:"+e.getMessage());
		} finally { if(s!=null) { try { s.close(); } catch (IOException e){System.out.println("close:"+e.getMessage()); } }
		}
		}
	}
}