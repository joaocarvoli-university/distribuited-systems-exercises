package ioflow;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

// Returns a thread to deal with all input flow of TCP communication

public class Input extends Thread{
    DataInputStream in;
    Socket clientSocket;
    BufferedReader br;
    String whoIs;

    public Input(Socket aClientSocket, String name){
        try {
            clientSocket = aClientSocket;
            whoIs = name;
            in = new DataInputStream(clientSocket.getInputStream());
        }catch(IOException e){
            System.out.println("Connection:"+e.getMessage());
        }
    }
    public void run(){
        String message = null;
        while(true){
            try{
                message = in.readUTF();
            } catch(IOException e){
                e.printStackTrace();
            }
            System.out.println(whoIs + ": " + message);        
        }
    }
}