package ai.code.mikasa.advanced.concurrent.examples.pc;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by Lenn on 2017/6/9.
 */
public class Producer implements Runnable, Printable {
    private List list;
    private Lock lock;
    private Condition isFull;
    private Condition isEmpty;

    public Producer(List list, Lock lock, Condition isFull, Condition isEmpty){
        this.list = list;
        this.lock = lock;
        this.isFull = isFull;
        this.isEmpty = isEmpty;
    }

    // 生产方法
    public void run() {
        try {
            lock.lock();
            String threadName = Thread.currentThread().getName();
            // limit 为 20
            // 只能用while，不能用if
            while (list.size() == 1){
                print(threadName, "容器已达上限，进入等待状态");
                isFull.await();
            }
            print(threadName, "生产一个产品放入容器。");
            list.add(new Object());
            isEmpty.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    @Override
    public void print(String name, String msg) {
        System.out.println(String.format("Producer: Thread Name:%s, %s", name, msg));
    }
}
