import java.io.IOException;

public class User {
    public static void main(String[] args) throws IOException {
        Proxy proxy = new Proxy("localhost", "Calculator");
        System.out.println("The sum is: " + proxy.add(1,2));
        System.out.println("The sub is: " + proxy.sub(2,2));
        System.out.println("The mul is: " + proxy.mul(2,2));
        System.out.println("The div is: " + proxy.div(4,2));
        proxy.closeApp();
    }
}
