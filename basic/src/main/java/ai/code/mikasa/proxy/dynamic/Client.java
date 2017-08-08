package ai.code.mikasa.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * Created by lenn on 16/10/23.
 */
public class Client {
    public static void main(String[] args){
        Subject realSubject = new RealSubject();
        SubjectInvocationHandler handler = new SubjectInvocationHandler(realSubject);
        // 生成一个代理对象
        Subject proxy = (Subject)Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                handler);
        // 调用相关方法
        proxy.doSomething();
    }
}
