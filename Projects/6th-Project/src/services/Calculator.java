package services;

import java.util.Objects;

public class Calculator {

    public double getSum(double a, double b){
        return a+b;
    }
    public double getSub(double a, double b){
        return a-b;
    }
    public double getProd(double a, double b){
        return a*b;
    }
    public double getDiv(double a, double b){
        if(b != 0){
            return a/b;
        }
        System.out.println("You cannot divide " + b + " per 0.");
        return 0;
    }
}
