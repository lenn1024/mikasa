package ai.code.mikasa.proxy.statics;

/**
 * Created by lenn on 16/10/23.
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("real subject is do something.");
    }
}
