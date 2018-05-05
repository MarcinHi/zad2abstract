package pattern.zad4;

import pattern.observator.Observator;

public class DeleteObservator implements Observator {
    @Override
    public void update(Object event) {
        if (event instanceof Blog.PostEvent) {
            Blog.PostEvent postEvent = (Blog.PostEvent) event;
            if (postEvent.getAction().equals("delete")) {
                System.out.println("cleaning up post: " + postEvent.getPost().getId());
            }

        }
    }
}
