package Data;

public class DataHandling {
    float[] values = new float[2];
    String operator;

    public float[] getValues(String data){
        String[] parts = data.split(",");
        this.values[0] = Float.parseFloat(parts[0]);
        this.values[1] = Float.parseFloat(parts[2]);
        return values;
    }

    public String getOperator(String data){
        String[] parts = data.split(",");
        this.operator = parts[1];
        return operator;
    }
}
