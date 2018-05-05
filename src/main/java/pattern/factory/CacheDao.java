package pattern.factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CacheDao implements Dao {

    private final Dao dao;
    private final Map<String, String> cache = new HashMap<>();

    public CacheDao(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void insert(String key, String value) throws IOException {
        dao.insert(key, value);
        cache.put(key,value);

    }

    @Override
    public String get(String key) throws IOException {
        return cache.get(key);
    }
}
