package ai.code.mikasa.advanced.concurrent.examples.pc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Object> container = new ArrayList<>();
        Lock lock = new ReentrantLock();
        Condition isFull = lock.newCondition();
        Condition isEmpty = lock.newCondition();

        // 构造10个生产者线程
        for(int i = 0; i < 3; i++){
            new Thread(new Producer(container, lock, isFull, isEmpty)).start();
        }

        // 构造10个消费者线程
        for(int i = 0; i < 3; i++){
            new Thread(new Consumer(container, lock, isFull, isEmpty)).start();
        }

        // 睡1s
        Thread.sleep(1000);
        System.out.println(container);
    }
}
