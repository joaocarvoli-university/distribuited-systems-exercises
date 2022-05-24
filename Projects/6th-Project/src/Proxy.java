import tcp.TCPClient;

import java.io.IOException;

public class Proxy {
    private TCPClient client;
    public Proxy(String serviceAddress, String ServiceId){
        client = new TCPClient(serviceAddress, ServiceId);
        client.execute();
    }

    public Double add(double op1, double op2) throws IOException {
        client.sendRequest("Sum" + "," + String.valueOf(op1) + "," + String.valueOf(op2));
        return Double.parseDouble(client.getResponse());
    }

    public Double sub(double op1, double op2) throws IOException {
        client.sendRequest("Sub" + "," + String.valueOf(op1) + "," + String.valueOf(op2));
        return Double.parseDouble(client.getResponse());
    }
    public Double mul(double op1, double op2) throws IOException {
        client.sendRequest("Mul" + "," + String.valueOf(op1) + "," + String.valueOf(op2));
        return Double.parseDouble(client.getResponse());
    }
    public Double div(double op1, double op2) throws IOException {
        client.sendRequest("Div" + "," + String.valueOf(op1) + "," + String.valueOf(op2));
        return Double.parseDouble(client.getResponse());
    }
    public void closeApp() throws IOException {
        client.close();
    }
}
