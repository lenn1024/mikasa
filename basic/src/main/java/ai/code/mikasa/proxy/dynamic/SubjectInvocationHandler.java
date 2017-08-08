package ai.code.mikasa.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lenn on 16/10/23.
 */
public class SubjectInvocationHandler implements InvocationHandler {

    private Subject subject;

    public SubjectInvocationHandler(Subject subject) {
        this.subject = subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do something before.");
        method.invoke(subject, args);
        System.out.println("do something after.");

        return null;
    }
}
