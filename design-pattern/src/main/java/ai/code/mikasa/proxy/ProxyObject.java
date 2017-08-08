package ai.code.mikasa.proxy;

/**
 * Created by lenn on 16/4/14.
 * 代理对象
 */
public class ProxyObject extends AbstractObject {
    RealObject realObject = new RealObject();
    @Override
    public void operation() {
        // 调用目标对象之前可以做一些操作
        System.out.println("before");
        realObject.operation();
        // 调用目标对象之后可以做一些操作
        System.out.println("after");
    }
}
