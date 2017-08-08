package ai.code.mikasa.advanced.concurrent.examples;

import java.util.concurrent.BlockingQueue;

/**
 * Created by lenn on 17/4/25.
 * 生产者
 */
public class Consumer implements Runnable  {
    private BlockingQueue<Integer> container;

    public Consumer(BlockingQueue container) {
        this.container = container;
    }

    public void consume() throws InterruptedException {
        Integer product = this.container.take();
        System.out.println("已消费了product: " + product);
    }

    @Override
    public void run() {
        while (true){
            try {
                consume();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
