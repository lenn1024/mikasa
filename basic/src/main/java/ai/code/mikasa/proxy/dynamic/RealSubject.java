package ai.code.mikasa.proxy.dynamic;

/**
 * Created by lenn on 16/10/23.
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("real subject is do something.");
    }
}
