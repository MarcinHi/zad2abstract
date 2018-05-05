package pattern.zad4;

public class Application {

    public static void main(String[] args) {
        Blog blog = new Blog();
        blog.attach(new FacebookObserver());
        blog.attach(new DeleteObservator());
        blog.attach(new LoggingObserver());

        blog.addPost("New post on my blog1");
        blog.addPost("New post on my blog2");
        blog.addPost("New post on my blog3");

        blog.removePost(1);
        blog.removePost(3);

    }
}
