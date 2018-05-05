package pattern.observator;

import abstractions.Group;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        ObservableList observableList = new ObservableList();
        observableList.attach(new PrintingObservator());
        observableList.attach(new PrintingObservator());
        List list = observableList;
        list.add("Hello");
        list.add("Hello1");
        list.add(new Group("grupa"));
    }
}
