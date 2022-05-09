package data;

public class DataHandlingServices {
    static String[] parts;

    public static int ServiceSelector(String data){
        parts  = data.split(",");
        return Integer.parseInt(parts[3]);
    }
}
