package ai.code.mikasa.advanced.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenn on 17/4/27.
 * 闭锁 实例
 * 一种同步方法，可以延迟线程的进度直到线程到达某个终点状态。
 * 通俗的讲就是，一个闭锁相当于一扇大门，在大门打开之前所有线程都被阻断，一旦大门打开所有线程都将通过，
 * 但是一旦大门打开，所有线程都通过了，那么这个闭锁的状态就失效了，门的状态也就不能变了，只能是打开状态。
 * 也就是说闭锁的状态是一次性的，它确保在闭锁打开之前所有特定的活动都需要在闭锁打开之后才能完成。
 */
public class Main {
    public static void main(String[] args){
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Employee employee1 = new Employee("张三", "宝马", countDownLatch);
        Employee employee2 = new Employee("李四", "悍马", countDownLatch);
        Employee employee3 = new Employee("王五", "兰博基尼", countDownLatch);

        Boss boss = new Boss("巨石强森", countDownLatch);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(boss);
        executor.execute(employee1);
        executor.execute(employee2);
        executor.execute(employee3);

        executor.shutdown();
    }
}
