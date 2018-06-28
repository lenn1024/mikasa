package test;

import org.apache.commons.lang3.math.NumberUtils;
import test.Test1;

import java.math.BigDecimal;
import java.util.concurrent.*;

public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Integer integer = 20;

        System.out.println(NumberUtils.toLong("20") == integer);
        System.out.println(integer == NumberUtils.toLong("20"));
        System.out.println(NumberUtils.toLong("20") == integer);

        /**
         *
         */
        System.out.println(Runtime.getRuntime().availableProcessors());

        /**
         *  使用 CompletableFuture 创建一些异步操作
         */

        // 1.
        CompletableFuture<String> futureAnimal = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Thread.sleep(100L);
                futureAnimal.complete("a dog.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (CompletionException ex){
                futureAnimal.completeExceptionally(ex);
            }
        }).start();

        System.out.println(futureAnimal.get(1, TimeUnit.SECONDS));

        // 2. supplyAsync 本身提供了异步线程的异常处理
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "a cat.";
        });

        System.out.println(future2.get(1, TimeUnit.MINUTES));

    }
}
