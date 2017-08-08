package ai.code.mikasa.proxy.statics;

/**
 * Created by lenn on 16/10/23.
 */
public class Client {
    public static void main(String[] args){
        ProxySubject proxy = new ProxySubject();
        proxy.setSubject(new RealSubject());
        // call method
        proxy.doSomething();
    }
}
