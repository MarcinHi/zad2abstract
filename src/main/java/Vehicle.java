
public abstract class Vehicle {

    private Integer maxSpeed;
    private String model;

    protected Vehicle(Integer maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format(
                "Class : %s, model: %s, speed: %s",
                this.getClass().getSimpleName(), this.model, this.maxSpeed);
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
