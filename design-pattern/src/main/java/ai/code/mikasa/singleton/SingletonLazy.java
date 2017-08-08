package ai.code.mikasa.singleton;

/**
 * Created by lenn on 16/11/26.
 * 懒汉模式
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    // 私有化的构造函数
    private SingletonLazy(){}

    /**
     * 静态方法返回单例对象
     * @return
     */
    public static SingletonLazy getInstance(){
        // 此处存在线程不安全的情况
        if(instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
