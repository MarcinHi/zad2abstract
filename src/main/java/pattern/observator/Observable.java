package pattern.observator;

public interface Observable {
    void attach(Observator observator);
    void detach(Observator observator);
}
