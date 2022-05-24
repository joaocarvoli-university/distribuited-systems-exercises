package tcp;

import java.net.*;
import java.io.*;
import dispatcher.Dispatcher;

public class TCPServer {
    public static void main (String[] args) {
        try{
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while(true) {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
                c.start();
            }
        } catch(IOException e) {System.out.println("Listen :"+e.getMessage());}
    }
}

class Connection extends Thread {
    Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    public Connection (Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(aClientSocket.getInputStream());
            out = new DataOutputStream(aClientSocket.getOutputStream());
        } catch(IOException e)  {System.out.println("tcp.Connection:"+e.getMessage());}
    }
    public void run(){
        try {
            while(true){
                String message = getRequest();
                Dispatcher dispatcher = new Dispatcher();
                String response = dispatcher.invoke(message);
                sendResponse(response);
            }

        } catch(EOFException e) {System.out.println("EOF Server:"+e.getMessage());
        } catch(IOException e) {System.out.println("IO Server:"+e.getMessage());
        } finally{
            try {
                //System.out.println("Closing connection to this client!");
                clientSocket.close();
            }catch (IOException e){/*close failed*/}
        }
    }
    public void sendResponse(String message) throws IOException {
        out.writeUTF(message);
    }
    public String getRequest() throws IOException {
        return in.readUTF();
    }
}