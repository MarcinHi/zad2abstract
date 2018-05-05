package pattern.singleton;


public final class Singleton {
    private static final Singleton INSTANCE;

    static {
        INSTANCE = new Singleton("Sth");
    }

    public final String port;

    private Singleton(String port){
        this.port = port;
    }

    public static Singleton getInstance(){
        return INSTANCE;
    }
}
