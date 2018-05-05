package pattern.factory;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();

        Dao file = DaoFactory.getDao("CACHE", "data.txt");
        for (int i = 0; i < 1000; i++) {
            file.insert(i+"", "hello"+i);
            System.out.println(file.get(i+""));
        }
        System.out.println(System.currentTimeMillis() - l);
    }

}
