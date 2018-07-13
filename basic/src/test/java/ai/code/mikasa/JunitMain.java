package ai.code.mikasa;

import ai.code.mikasa.filter.MethodFilter;
import ai.code.mikasa.listener.JunitListener;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class JunitMain {
    public static void main(String[] args){
        RunNotifier notifier = new RunNotifier();
        notifier.addListener(new JunitListener());
        try {
            Runner runner = new BlockJUnit4ClassRunner(JunitTest.class);
            ((BlockJUnit4ClassRunner) runner).filter(new MethodFilter("testFilteredOut"));
            runner.run(notifier);
        } catch (InitializationError initializationError) {
            initializationError.printStackTrace();
        } catch (NoTestsRemainException e) {
            e.printStackTrace();
        }
    }
}
