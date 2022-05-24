package skeleton;

import java.util.Objects;

import data.DataHandlingCalculator;
import services.Calculator;

public class SKCalculator {
    private DataHandlingCalculator dataHandled;
    private Calculator calculator;
    private String operator;
    private double valueA;
    private double valueB;

    public SKCalculator(String message){
        calculator = new Calculator();
        dataHandled = new DataHandlingCalculator(message);
        String operator = dataHandled.getOperator();
        double valueA = dataHandled.getValueA();
        double valueB = dataHandled.getValueB();
    }
    public String doCalc(){
        if(Objects.equals(operator, "Sum")) return String.valueOf(calculator.getSum(valueA, valueB));
        else if(Objects.equals(operator, "Sub")) return String.valueOf(calculator.getSub(valueA, valueB));
        else if(Objects.equals(operator, "Mul")) return String.valueOf(calculator.getProd(valueA, valueB));
        else if(Objects.equals(operator, "Div")) return String.valueOf(calculator.getDiv(valueA, valueB));
        return null;
    }
}
