package data;

public class DataHandlingServices {
    static String[] parts;

    public static String ServiceSelector(String data){
        parts  = data.split(",");
        return parts[3];
    }
}
