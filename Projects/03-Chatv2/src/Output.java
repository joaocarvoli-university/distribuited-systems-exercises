import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

// Returns a thread to deal with all output flow of TCP communication

public class Output extends Thread{
    DataOutputStream out;
    Socket clientSocket;
    BufferedReader br;

    public Output(Socket aClientSocket){
        try {
            clientSocket = aClientSocket;
            out = new DataOutputStream(clientSocket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
        }catch(IOException e){
            System.out.println("Connection:"+e.getMessage());
        }
    }
    public void run(){
        String message = null;
        while(true){
            try {
                message = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
