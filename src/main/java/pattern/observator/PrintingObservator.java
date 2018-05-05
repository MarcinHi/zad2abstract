package pattern.observator;

public class PrintingObservator implements Observator{
    @Override
    public void update(Object o) {
        System.out.println(o);
    }
}
