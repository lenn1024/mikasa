package ai.code.mikasa.singleton;

/**
 * Created by lenn on 16/11/26.
 * 线程安全的懒汉模式
 */
public class SingletonLazySecure {
    private static SingletonLazySecure instance;

    // 私有化的构造函数
    private SingletonLazySecure(){}

    /**
     * 静态方法返回单例对象(线程安全,但存在一定程度的性能下降)
     * @return
     */
    public static synchronized SingletonLazySecure getInstance(){
        if(instance == null){
            instance = new SingletonLazySecure();
        }
        return instance;
    }
}
