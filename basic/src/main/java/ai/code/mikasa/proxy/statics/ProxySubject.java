package ai.code.mikasa.proxy.statics;

/**
 * Created by lenn on 16/10/23.
 */
public class ProxySubject implements Subject {
    private Subject subject;

    public void setSubject(Subject subject){
        this.subject = subject;
    }

    @Override
    public void doSomething() {
        System.out.println("do something before.");
        subject.doSomething();
        System.out.println("do something after.");
    }
}
