package pattern.factory;

public final class DaoFactory {

    public static Dao getDao(String type, String path){
        switch (type){
            case "FILE": return new DefaultDao(path);
            case "CACHE": return new CacheDao(new DefaultDao(path));
            default: throw new RuntimeException("no dao for given type");
        }
    }
}
