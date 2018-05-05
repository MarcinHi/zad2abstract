package interf;


public class Application {

    public static void main(String[] args) {
        Url url = new StandardUrl();
        System.out.println(url.getParam("param1", "url_example?param1=99&param2=string"));
        url = new ExtendedUrl();
        System.out.println(url.getParam("param2", "url_example/param1.99/param2.string"));
    }
}
