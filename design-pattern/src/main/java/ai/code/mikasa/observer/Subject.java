package ai.code.mikasa.observer;

/**
 * Created by lenn on 16/7/5.
 * 抽象主题类
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
