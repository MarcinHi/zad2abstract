public class Train extends Vehicle {

    private Integer trackWidth;

    public Train(Integer maxSpeed, String model, Integer trackWidth) {
        super(maxSpeed, model);
        this.trackWidth = trackWidth;
    }

    public Integer getTrackWidth() {
        return trackWidth;
    }

    public void setTrackWidth(Integer trackWidth) {
        this.trackWidth = trackWidth;
    }
}
