package ai.code.mikasa.singleton;

/**
 * Created by lenn on 16/11/26.
 * 饿汉模式
 */
public class SingletonHungry {
    // 在加载类的时候就已经初始化单例对象
    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {}

    public static SingletonHungry getInstance(){
        return instance;
    }
}
