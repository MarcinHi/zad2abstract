package pattern.observator;

import java.util.ArrayList;
import java.util.List;

public class ObservableList extends ArrayList implements Observable {

    private final List<Observator> observables = new ArrayList<>();

    public void attach(Observator observator) {
        observables.add(observator);
    }

    public void detach(Observator observator) {
        observables.remove(observator);
    }

    @Override
    public boolean add(Object o) {
        dispatchEvent(o);
        return super.add(o);
    }

    private void dispatchEvent(Object o){
        for (Observator observable : observables) {
            observable.update(o);
        }
    }
}
