package ai.code.mikasa.advanced.concurrent.examples.producer_and_consumer;

import java.util.List;

/**
 * Created by Lenn on 2017/6/9.
 */
public class Producer implements Runnable, Printable {
    private List list;
    private Object signal;

    public Producer(List list, Object signal){
        this.list = list;
        this.signal = signal;
    }

    // 生产方法
    public void run() {
        try {
            synchronized (signal){
                String threadName = Thread.currentThread().getName();
                // limit 为 20
                if(list.size() == 20){
                    print(threadName, "容器已达上限，进入等待状态");
                    wait();
                }
                print(threadName, "生产一个产品放入容器。");
                list.add(new Object());
                signal.notifyAll();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print(String name, String msg) {
        System.out.println(String.format("Producer: Thread Name:%s, %s", name, msg));
    }
}
