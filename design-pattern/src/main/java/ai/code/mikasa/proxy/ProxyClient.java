package ai.code.mikasa.proxy;

/**
 * Created by lenn on 16/4/14.
 */
public class ProxyClient {
    public static void main(String[] args) {
        AbstractObject obj = new ProxyObject();
        obj.operation();
    }
}
