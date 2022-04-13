import java.io.*;
import java.net.Socket;

class Connection extends Thread {
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    BufferedReader br;
    Chat chat = new Chat();

    public Connection (Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch(IOException e){
            System.out.println("Connection:"+e.getMessage());
        }
    }
    public void run(){
        try {
            this.start();
            chat.communication(in, out, br, "Server"); // Establishing connection

        } catch(EOFException e){
            System.out.println("EOF:"+e.getMessage());
        } catch(IOException e){
            System.out.println("IO:"+e.getMessage());
        } finally{
            try{
                clientSocket.close();
            }catch (IOException e){
                /*close failed*/
            }
        }
    }
}