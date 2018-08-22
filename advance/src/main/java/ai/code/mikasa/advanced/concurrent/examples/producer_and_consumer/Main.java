package ai.code.mikasa.advanced.concurrent.examples.producer_and_consumer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Object> container = new ArrayList<>();
        Object signal = new Object();
        // 构造10个生产者线程
        for(int i = 0; i < 5; i++){
            new Thread(new Producer(container, signal)).start();
        }

        // 构造10个消费者线程
        for(int i = 0; i < 5; i++){
            new Thread(new Consumer(container, signal)).start();
        }

        // 睡1s
        Thread.sleep(1000);
        System.out.println(container);
    }
}
