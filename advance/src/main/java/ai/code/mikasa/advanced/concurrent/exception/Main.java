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

//        ThreadGroup group = thread.getThreadGroup();
//        Thread.UncaughtExceptionHandler handler = thread.getUncaughtExceptionHandler();
//        thread.setUncaughtExceptionHandler(new MyExceptionHandler());
//        Thread.UncaughtExceptionHandler handler1 = thread.getUncaughtExceptionHandler();

        thread.start();
    }
}
