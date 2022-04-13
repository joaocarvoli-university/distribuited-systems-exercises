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
                toRead = in.readUTF();
                thread.start();
                
            }
        } else if(type.equals("Server")){
            while(!toRead.equals("Off")){
                toRead = in.readUTF();
                System.out.println("Client: " + toRead);
                thread.start();
                toSend = br.readLine();
                out.writeUTF(toSend);
                out.flush();
            }
        } else System.out.println("This type is invalid!");
    }
}
