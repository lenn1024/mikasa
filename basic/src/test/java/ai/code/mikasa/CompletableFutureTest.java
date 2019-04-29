package ai.code.mikasa;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    @Test
    public void testSupplyAsync(){
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            delay();
            return 100;
        });
        displayCompletableFuture(completableFuture);
    }

    @Test
    public void testSupplyAsyncEx(){
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            delay();
            throw new RuntimeException("runtime ex.");
        });
        displayCompletableFuture(completableFuture);
    }

    @Test
    public void testRunAsync(){
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            delay();
        });
        displayCompletableFuture(completableFuture);
    }

    @Test
    public void testWhenComplete(){
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            delay();
            return 100;
        });

        completableFuture.whenComplete((v, e) -> {
            display(v);
        });

        displayCompletableFuture(completableFuture);
    }

    @Test
    public void testWhenCompleteEx(){
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("exception.");
        });

        completableFuture.whenComplete((v, e) -> {
            if(e != null){
                displayEx(e);
            }
        });
    }

    @Test
    public void testThenApply(){
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            delay();
            return 100;
        });

        CompletableFuture<String> future = completableFuture.thenApply(v -> {
            return "str: " + v.toString();
        });

        displayCompletableFuture(future);
    }

    @Test
    public void testThenAccept(){
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            delay();
            return 100;
        });

        completableFuture.thenAccept(v -> {
            display(v);
        });

        displayCompletableFuture(completableFuture);
    }

    @Test
    public void testThenCompose(){
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            delay();
            return 100;
        });

        CompletableFuture<String> future = completableFuture.thenCompose(v -> {
            return CompletableFuture.supplyAsync(() -> {
                return "str: " + (v * 100);
            });
        });

        displayCompletableFuture(future);
    }

    @Test
    public void testThenCombine(){
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            delay();
            return 100;
        });

        CompletableFuture<Integer> combineFuture = completableFuture.thenCombine(CompletableFuture.supplyAsync(() -> {
            delay();
            return 200;
        }), (v1, v2) -> {
            return v1 * v2;
        });

        displayCompletableFuture(combineFuture);
    }


    private void display(Object object){
        System.out.println("display: " + object);
    }

    private void displayEx(Throwable e){
        System.out.println("抛异常了。" + e.getMessage());
    }

    private void displayCompletableFuture(CompletableFuture<? extends Object> future){
        System.out.println("displayCompletableFuture: " + future.join());
    }

    private void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
