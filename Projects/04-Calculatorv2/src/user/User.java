package user;
import tcp.*;

import java.util.Scanner;


public class User {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Which service do you wanna access?" + "\n" + "Calculator(1) or CurrencyConverter(2)?");
        int service = Integer.parseInt(input.next());

        if(service == 1){
            System.out.println("What do you wanna calculate? - format: (Sum,Div,Sub,Mul),value1,value2");
        } else {
            System.out.println("For what currency do you wanna convert yours? - format: (Dollar or Real), valueReal, valueDollar");
        }
        String message = input.next();
        String serverAddress = "localhost";

        TCPClient client = new TCPClient(message, serverAddress, service);
        client.execute();

    }
}
