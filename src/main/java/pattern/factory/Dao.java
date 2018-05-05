package pattern.factory;

import java.io.IOException;

public interface Dao {
    void insert(String key, String value) throws IOException;
    String get(String key) throws IOException;
}
