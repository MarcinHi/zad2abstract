package pattern.zad4;

import pattern.observator.Observable;
import pattern.observator.Observator;

import java.util.ArrayList;
import java.util.List;

public class Blog implements Observable {

    static int count = 0;

    private final List<Post> posts;
    private final List<Observator> observators;

    public Blog() {
        this.posts = new ArrayList<>();
        this.observators = new ArrayList<>();
    }

    public void addPost(String message){
        Post post = new Post(++count, message);
        posts.add(post);
        notifyObservators(new PostEvent(post, "add"));
    }

    public void removePost(int id){
        for (Post post : posts) {
            if(post.getId() == id){
                posts.remove(post);
                notifyObservators(new PostEvent(post, "delete"));
                break;
            }
        }
    }

    @Override
    public void attach(Observator observator) {
        observators.add(observator);
    }

    @Override
    public void detach(Observator observator) {
        observators.remove(observator);
    }

    private void notifyObservators(PostEvent postEvent){
        for (Observator observator : observators) {
            observator.update(postEvent);
        }
    }

    public static class PostEvent {
        private final Post post;
        private final String action;

        public PostEvent(Post post, String action) {
            this.post = post;
            this.action = action;
        }

        public Post getPost() {
            return post;
        }

        public String getAction() {
            return action;
        }

        @Override
        public String toString() {
            return "PostEvent{" +
                    "post=" + post +
                    ", action='" + action + '\'' +
                    '}';
        }
    }
}
