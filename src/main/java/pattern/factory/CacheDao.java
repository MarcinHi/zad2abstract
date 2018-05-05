package pattern.factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheDao implements Dao {

    private final Dao dao;
    private final Map<String, String> cache = new HashMap<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    public CacheDao(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void insert(String key, String value) throws IOException {
        executorService.submit(() -> {
            try {
                dao.insert(key, value);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        cache.put(key,value);

    }

    @Override
    public String get(String key) throws IOException {
        return cache.get(key);
    }
}
