package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class TCPClient{
    private String serverAddress;
    private DataInputStream in;
    private DataOutputStream out;
    private String service;
    private Socket socket;
    public TCPClient(String newServerAddress, String serviceId) {
        serverAddress = newServerAddress;
        service = serviceId;
    }

    public void execute(){
        Socket socket = null;
        { try{
            int serverPort = 7896;
            socket = new Socket(serverAddress, serverPort);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException e){System.out.println("Sock Client:"+e.getMessage());
        } catch (EOFException e){ System.out.println("EOF Client:"+e.getMessage());
        } catch (IOException e){ System.out.println("IO Client:"+e.getMessage());
        } //finally { if(socket!=null) { try { socket.close(); } catch (IOException e){System.out.println("close:"+e.getMessage()); } }
        //}
        }
    }
    public void sendRequest(String message) throws IOException {
        out.writeUTF(message + "," + service);
    }
    public String getResponse() throws IOException {
        return in.readUTF();
    }
    public void close() throws IOException {
        System.out.println("The connection was closed!");
        if(socket != null) socket.close();
    }
}