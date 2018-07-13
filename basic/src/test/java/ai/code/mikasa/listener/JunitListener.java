package ai.code.mikasa.listener;

import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

public class JunitListener extends RunListener {

    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println(description);

        System.out.println("method：" + description.getMethodName() + " ignored.");
    }
}
