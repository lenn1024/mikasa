package ai.code.mikasa.advanced.concurrent.examples.producer_and_consumer;

import java.util.List;

/**
 * Created by Lenn on 2017/6/9.
 */
public class Consumer implements Runnable, Printable {
    private List list;
    private Object signal;

    public Consumer(List list, Object signal){
        this.list = list;
        this.signal = signal;
    }

    // 消费方法
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            synchronized (signal){
                if(list.size() == 0){
                    print(threadName, "容器中已没有商品，进入等待状态。");
                    signal.wait();
                }
                // 消费掉
                print(threadName, "消费掉一个商品。");
                list.remove(0);
                signal.notifyAll();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void print(String name, String msg) {
        System.out.println(String.format("Consumer: Thread Name:%s, %s", name, msg));
    }
}
