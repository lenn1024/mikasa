package ai.code.mikasa.advanced.concurrent.examples.producer_and_consumer;

import java.util.List;

/**
 * Created by Lenn on 2017/6/9.
 */
public class Consumer {
    private List list;
    private Object lock;

    public Consumer(List list, Object lock){
        this.list = list;
        this.lock = lock;
    }

    // 消费方法
    public void consume() throws InterruptedException {
        synchronized (lock){
            if(list.size() == 0){
                lock.wait();
            }
            // 消费掉
            list.remove(0);
            lock.notifyAll();
        }
    }
}
