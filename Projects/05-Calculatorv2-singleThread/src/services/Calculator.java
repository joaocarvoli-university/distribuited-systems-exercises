package src.services;

import java.util.Objects;

public class Calculator {

    public double doCalc(String operator, double firstNumber, double secondNumber){
        if(Objects.equals(operator, "Sum")) return getSum(firstNumber, secondNumber);
        else if(Objects.equals(operator, "Sub")) return getSub(firstNumber, secondNumber);
        else if(Objects.equals(operator, "Mul")) return getProd(firstNumber, secondNumber);
        else if(Objects.equals(operator, "Div")) return getDiv(firstNumber, secondNumber);
        else return 1;
    }

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
        try {
            if(b != 0){
                return a/b;
            }
        }catch (Exception e){
            System.out.println("You cannot divide " + b + " per 0.");
        }
        return 0;
    }
}
