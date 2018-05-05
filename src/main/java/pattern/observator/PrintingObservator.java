package pattern.observator;

public class PrintingObservator implements Observator{
    @Override
    public void update(Object event) {
        System.out.println(event);
    }
}
