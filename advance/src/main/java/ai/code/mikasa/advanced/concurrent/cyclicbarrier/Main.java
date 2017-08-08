package ai.code.mikasa.advanced.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenn on 17/4/27.
 * 栅栏
 * 栅栏类似于闭锁，它能阻塞一组线程直到某个事件发生。 栅栏与闭锁的关键区别在于，所有的线程必须同时到达栅栏位置，
 * 才能继续执行。闭锁用于等待事件，而栅栏用于等待其他线程。
 *
 * 场景： 应用一些协议，比如几个家庭成员决定在某个地方集合，所有人在6：00在某地集合，到了以后要等待其他人，之后才能讨论去哪里吃饭。
 * 并行迭代，将一个问题分成很多子问题，当一系列的子问题都解决之后（所有子问题线程都已经await（）），
 * 此时将栅栏打开，所有子问题线程被释放，而栅栏位置可以留着下次使用。
 */
public class Main {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("do the next thing.");
            }
        });

        Employee employee1 = new Employee("张三", "宝马", cyclicBarrier);
        Employee employee2 = new Employee("李四", "悍马", cyclicBarrier);
        Employee employee3 = new Employee("王五", "兰博基尼", cyclicBarrier);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(employee1);
        executor.execute(employee2);
        executor.execute(employee3);

        executor.shutdown();
    }
}
