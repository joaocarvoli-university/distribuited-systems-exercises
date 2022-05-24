package src.flow;

import java.net.*;
import java.io.*;

public class Dispatcher {
    private DataInputStream in;
    private DataOutputStream out;

    public Dispatcher(Socket newSocket) throws IOException {
        in = new DataInputStream(newSocket.getInputStream());
        out = new DataOutputStream(newSocket.getOutputStream());
    }

    public String getRequest() throws IOException{
        return in.readUTF();
    }
    public String getResponse() throws IOException {
        return in.readUTF();
    }
    public void sendRequest(String message) throws IOException {
        out.writeUTF(message);
    }
    public void sendResponse(String message) throws IOException {
        out.writeUTF(message);
    }
}
