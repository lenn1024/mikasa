package ai.code.mikasa.observer;

/**
 * Created by lenn on 16/7/5.
 */
public class NewsReader implements Observer {
    @Override
    public void update(Subject subject) {
        System.out.println(this.hashCode() + ": 我阅读了这条新闻.");
    }
}
