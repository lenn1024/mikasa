package ai.code.mikasa.advanced.concurrent.exception;

/**
 * Created by lenn on 17/4/26.
 */
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.print("default handle...");
    }
}
