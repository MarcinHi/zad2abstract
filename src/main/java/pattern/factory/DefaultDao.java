package pattern.factory;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class DefaultDao implements Dao{

    private final Path path;

    public DefaultDao(String path){
        this.path = Paths.get(path);
    }

    @Override
    public void insert(String key, String value) throws IOException {
        byte[] bytes = (key + ":" + value + System.lineSeparator()).getBytes();
        Files.write(path, bytes, StandardOpenOption.APPEND);
    }

    @Override
    public String get(String key) throws IOException {
        List<String> strings = Files.readAllLines(path);
        for (String line : strings) {
            String[] split = line.split(":");
            if(split[0].equals(key)){
                return split[1];
            }
        }
        return null;
    }

}
