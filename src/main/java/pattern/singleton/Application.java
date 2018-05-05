package pattern.singleton;

public class Application {


    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance.port);
    }
}
