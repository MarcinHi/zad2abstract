package pattern.zad4;

import pattern.observator.Observator;

public class FacebookObserver implements Observator {

    @Override
    public void update(Object event) {
        if (event instanceof Blog.PostEvent) {
            Blog.PostEvent postEvent = (Blog.PostEvent) event;
            if (postEvent.getAction().equals("add")) {
                System.out.println("posting to facebook message: " +
                        postEvent.getPost().getMessage());
            }
        }
    }
}
