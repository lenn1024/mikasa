package ai.code.mikasa.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.print("异常。");
                e.printStackTrace();
            }
            System.out.println("task end。");
        });

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("运行关闭钩子。");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));

//        System.exit(0);
        executor.shutdown();
        while (!executor.awaitTermination(1, TimeUnit.SECONDS)){
            System.out.println("continue await。");
        }

        System.out.println("main end。");
    }
}
