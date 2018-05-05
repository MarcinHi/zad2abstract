package pattern.zad2;

public final class ProductFactory {
    public static Product createProduct(String type) {
        switch (type) {
            case "simple": return new SimpleProduct();
            case "advance": return new AdvanceProduct();
            case "virtual": return new VirtualProduct();
            default: throw new RuntimeException("no product for type: " + type);
        }
    }
}
