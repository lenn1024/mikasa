package ai.code.mikasa.advanced.concurrent.examples.pc;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by Lenn on 2017/6/9.
 */
public class Consumer implements Runnable, Printable {
    private List list;
    private Lock lock;
    private Condition isFull;
    private Condition isEmpty;

    public Consumer(List list, Lock lock, Condition isFull, Condition isEmpty){
        this.list = list;
        this.lock = lock;
        this.isFull = isFull;
        this.isEmpty = isEmpty;
    }

    // 消费方法
    public void run() {
        try {
            lock.lock();
            String threadName = Thread.currentThread().getName();
            while (list.size() == 0){
                print(threadName, "容器中已没有商品，进入等待状态。");
                isEmpty.await();
            }
            // 消费掉
            print(threadName, "消费掉一个商品。");
            list.remove(0);
            isFull.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void print(String name, String msg) {
        System.out.println(String.format("Consumer: Thread Name:%s, %s", name, msg));
    }
}
