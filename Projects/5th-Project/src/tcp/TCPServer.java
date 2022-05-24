package src.tcp;

import src.flow.*;
import src.services.*;
import src.data.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;


public class TCPServer {
    public static void main (String[] args) {
        try{
            int serverPort = 7897;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            Dispatcher dispatcher;
            while(true) {
                Socket clientSocket = listenSocket.accept();
                dispatcher = new Dispatcher(clientSocket);
                String message = dispatcher.getRequest();
                int service = DataHandlingServices.ServiceSelector(message);
                double result = 0;

                if(service == 1)
                {
                    Calculator calc = Calculator.getInstance();
                    DataHandlingCalculator dataHandled = new DataHandlingCalculator(message);
                    result = calc.doCalc(dataHandled.getOperator(),dataHandled.getValueA(), dataHandled.getValueB());
                }
                else if(service == 2)
                {
                    CurrencyConverter converter = CurrencyConverter.getInstance();
                    DataHandlingConverse dataHandled = new DataHandlingConverse(message);

                    if((dataHandled.getCurrency()).equals("Dollar"))
                    {
                        result = converter.DollarToReal(dataHandled.getRealValue(),dataHandled.getDollarValue());
                    }
                    else if((dataHandled.getCurrency()).equals("Real"))
                    {
                        result = converter.RealToDollar(dataHandled.getRealValue(),dataHandled.getDollarValue());
                    }
                }

                sleep(100);
                dispatcher.sendResponse(String.valueOf(result));
            }
        } catch(IOException e) {System.out.println("Listen :"+e.getMessage());} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}