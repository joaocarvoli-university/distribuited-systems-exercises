import java.io.*;

public class ReadData {
    public void clientReader(DataInputStream in, DataOutputStream out, BufferedReader br) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		String strToServer = "", strToClient = "";

		while(!strToServer.equals("Off")){
			strToServer = br.readLine();
			out.writeUTF(strToServer); // to send the packet to the consumer queue
			out.flush(); // this forces any data buffered output bytes to be written out to the stream
			strToClient = in.readUTF(); // to read the packet from the my queue (sent by producer)
			System.out.println("Server: " + strToClient);
		}
	}
    public void serverReader(DataInputStream in, DataOutputStream out, BufferedReader br) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
        String strFromClient = "", strToClient = "";

        while(!strFromClient.equals("Off")){
            strFromClient = in.readUTF();
            System.out.println("client: " + strFromClient);
            strToClient = br.readLine();
            out.writeUTF(strToClient);
            out.flush();
        }
	}
}
