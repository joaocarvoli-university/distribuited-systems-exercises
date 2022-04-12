import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receiver implements Runnable{
    DataInputStream in;
    Socket clientSocket;
    BufferedReader br;

    public Receiver(Socket aClientSocket){
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
        }catch(IOException e){
            System.out.println("Connection:"+e.getMessage());
        }
    }
    public void run(){
        String message = null;
        while(true){
            try {
                message = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("fulano: " + message);
        }
    }
}