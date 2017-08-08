package ai.code.mikasa.advanced.concurrent.examples;

import java.util.concurrent.BlockingQueue;

/**
 * Created by lenn on 17/4/25.
 * 生产者
 */
public class Producer implements Runnable {
    private BlockingQueue<Integer> container;

    public Producer(BlockingQueue<Integer> container) {
        this.container = container;
    }

    public void produce(Integer product) throws InterruptedException {
        this.container.put(product);
        System.out.println("已生产了product: " + product);
    }

    @Override
    public void run() {
        while (true){
            int num = (int)(Math.random() * 1000);
            try {
                produce(num);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
