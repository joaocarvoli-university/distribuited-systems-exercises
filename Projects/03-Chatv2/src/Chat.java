import java.io.*;

public class Chat {
    static String toSend = " ";
    static String toRead = " ";
    public void communication(DataInputStream in, DataOutputStream out, BufferedReader br, String type) throws IOException {
        if(type.equals("Client")){
            while(!toSend.equals("Off")){
                toSend = br.readLine();
                out.writeUTF(toSend);
                out.flush();
                Thread thread = new Thread(new Bidirectional(type, in));
                thread.start();
                
            }
        } else if(type.equals("Server")){
            while(!toRead.equals("Off")){
                Thread thread = new Thread(new Bidirectional(type, in));
                thread.start();
                toSend = br.readLine();
                out.writeUTF(toSend);
                out.flush();
            }
        } else System.out.println("This type is invalid!");
    }

    private static class Bidirectional implements Runnable{
        public Bidirectional(String type, DataInputStream in) throws IOException {
            toRead = in.readUTF();
            if(type.equals("Client")) System.out.println("Server: " + toRead);
            else if(type.equals("Server")) System.out.println("Client: " + toRead);
        }
        public void run(){
        }
    }
}
