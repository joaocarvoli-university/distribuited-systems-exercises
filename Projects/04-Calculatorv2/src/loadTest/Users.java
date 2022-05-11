package loadTest;
import tcp.*;

public class Users {
    public static void main(String[] args){
        String serverAddress = "localhost";
        String message = "Sum,1,1";
        int service = 1;

        int amountClients = 10;
        Thread[] threads = new Thread[amountClients];

        long start = System.currentTimeMillis();
        for(int i = 0; i < amountClients; i++){
            threads[i] = new Thread(() -> {
                TCPClient client = new TCPClient(message, serverAddress, service);
                client.execute();
            });
            threads[i].start();
        }

        for(int i = 0; i < amountClients; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("The final time is: " + elapsedTime + "ms");
    }
}
