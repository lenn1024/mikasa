package ai.code.mikasa.advanced.concurrent.exception;

/**
 * Created by lenn on 17/4/26.
 */
public class Main {
    public static void main(String[] args){
        Thread thread = new Thread(){
            @Override
            public void run(){
                throw new RuntimeException();
            }
        };

//        ThreadGroup group = t1.getThreadGroup();
//        Thread.UncaughtExceptionHandler handler = t1.getUncaughtExceptionHandler();
//        t1.setUncaughtExceptionHandler(new MyExceptionHandler());
//        Thread.UncaughtExceptionHandler handler1 = t1.getUncaughtExceptionHandler();

        thread.start();
    }
}
