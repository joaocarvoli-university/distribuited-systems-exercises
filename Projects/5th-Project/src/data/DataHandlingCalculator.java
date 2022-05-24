package src.data;

public class DataHandlingCalculator {
    String[] parts;

    public DataHandlingCalculator(String data){
        parts  = data.split(",");
    }
    public String getOperator(){
        return parts[0];
    }
    public double getValueA(){
        return Double.parseDouble(parts[1]);
    }
    public double getValueB(){
        return Double.parseDouble(parts[2]);
    }
}