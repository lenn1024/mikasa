package ai.code.mikasa.advanced.concurrent.examples.producer_and_consumer;

import java.util.List;

/**
 * Created by Lenn on 2017/6/9.
 */
public class Producer {
    private List list;
    private Object lock;

    public Producer(List list, Object lock){
        this.list = list;
        this.lock = lock;
    }

    // 生产方法
    public void produce() throws InterruptedException {
        synchronized (lock){
            // limit 为 20
            if(list.size() == 20){
                wait();
            }
            list.add(new Object());
            lock.notifyAll();
        }
    }

}
