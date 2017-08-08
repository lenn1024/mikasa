package ai.code.mikasa.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenn on 16/7/5.
 * 实现抽象主题类的具体主题类
 */
public class NewsSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news = null;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(this);
        }
    }

    public void publishNews(){
        System.out.println("发布一篇新文章.");
        this.news = "hello observer pattern.";
        this.notifyObservers();
    }
}
