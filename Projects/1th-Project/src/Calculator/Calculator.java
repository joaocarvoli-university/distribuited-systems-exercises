package Calculator;

import java.util.Objects;

public class Calculator {

    public float doCalc(float firstNumber, float secondNumber, String operator){
        if(Objects.equals(operator, "+")) return getSum(firstNumber, secondNumber);
        else if(Objects.equals(operator, "-")) return getSub(firstNumber, secondNumber);
        else if(Objects.equals(operator, "*")) return getProd(firstNumber, secondNumber);
        else return getDiv(firstNumber, secondNumber);
    }

    public float getSum(float a, float b){
        return a+b;
    }
    public float getSub(float a, float b){
        return a-b;
    }
    public float getProd(float a, float b){
        return a*b;
    }
    public float getDiv(float a, float b){
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
