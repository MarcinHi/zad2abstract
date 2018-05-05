package pattern.zad1;

import java.io.IOException;
import java.util.Properties;

public final class AppConfig {
    private static final AppConfig INSTANCE;

    static {
        try {
            Properties properties = new Properties();
            properties.load(AppConfig.class.getResourceAsStream("/application.properties"));
            INSTANCE = new AppConfig(properties.getProperty("product.type"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final String productType;

    private AppConfig(String productType){
        this.productType = productType;
    }

    public static AppConfig getConfig() {
        return INSTANCE;
    }

    public String getProductType() {
        return productType;
    }
}
