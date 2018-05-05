package pattern.zad2;

import pattern.zad1.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig config = AppConfig.getConfig();
        Product product = ProductFactory.createProduct(config.getProductType());
        System.out.println(product.getType());
    }
}
