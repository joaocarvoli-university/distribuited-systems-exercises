package src.tcp;

import java.net.*;
import java.io.*;
import data.DataHandlingCalculator;
import data.DataHandlingConverse;
import data.DataHandlingServices;
import services.Calculator;
import src.flow.*;
import services.CurrencyConverter;
import static java.lang.Thread.sleep;


public class TCPServer {
    public static void main (String[] args) {
        try{
            int serverPort = 7896;
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
                    Calculator calc = new Calculator();
                    DataHandlingCalculator dataHandled = new DataHandlingCalculator(message);
                    result = calc.doCalc(dataHandled.getOperator(),dataHandled.getValueA(), dataHandled.getValueB());
                }
                else if(service == 2)
                {
                    CurrencyConverter converter = new CurrencyConverter();
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