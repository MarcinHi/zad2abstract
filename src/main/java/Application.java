
public class Application {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[]{
                new Car(150, "TOYOTA", "SUV"),
                new Train(300, "PENDOLINO", 600)};

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
