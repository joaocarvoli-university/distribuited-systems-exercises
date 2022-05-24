package data;

public class DataHandlingConverse {
    String[] parts;

    public DataHandlingConverse(String data){
        parts  = data.split(",");
    }
    public String getCurrency(){
        return parts[0];
    }
    public double getRealValue(){
        return Double.parseDouble(parts[1]);
    }
    public double getDollarValue(){
        return Double.parseDouble(parts[2]);
    }
}
