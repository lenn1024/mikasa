package ai.code.mikasa.singleton;

/**
 * Created by lenn on 16/11/26.
 * 升级版的线程安全的懒汉模式
 */
public class SingletonLazySecureUpdate {
    private static SingletonLazySecureUpdate instance;

    private SingletonLazySecureUpdate() {}

    /**
     * 此为推荐实现
     * @return
     */
    public static SingletonLazySecureUpdate getInstance(){
        if(instance == null){
            synchronized (SingletonLazySecureUpdate.class){
                if(instance == null){
                    instance = new SingletonLazySecureUpdate();
                }
            }
        }

        return instance;
    }
}
