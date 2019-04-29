package ai.code.mikasa.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class CompletionServiceMain {
    private static Logger logger = LoggerFactory.getLogger(CompletionServiceMain.class);
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                20,
                20,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );


        threadPoolExecutor.submit(() -> {
            System.out.println("============ start ==========");

            System.out.println("============ end ============");
        });
    }

    public static void test() throws InterruptedException {
        CompletionService<String> completionService = new ExecutorCompletionService<String>(Executors.newFixedThreadPool(5));

        completionService.submit(() -> {
            logger.info("start sleep 1s.");
            Thread.sleep(1000);
            logger.info("end sleep 1s.");
            return "1";
        });

        completionService.submit(() -> {
            logger.info("start sleep 2s.");
            Thread.sleep(2000);
            logger.info("end sleep 2s.");
            return "1";
        });

        completionService.submit(() -> {
            logger.info("start sleep 3s.");
            Thread.sleep(3000);
            logger.info("end sleep 3s.");
            return "1";
        });

        for (int i = 0; i < 3; i++){
            completionService.take();
        }
    }
}
