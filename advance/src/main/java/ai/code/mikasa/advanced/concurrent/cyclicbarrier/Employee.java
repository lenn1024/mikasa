package ai.code.mikasa.advanced.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by lenn on 17/4/27.
 */
public class Employee implements Runnable {
    private String name;
    private String car;
    private CyclicBarrier cyclicBarrier;

    public Employee(String name, String car, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.car = car;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        goToWork();
        System.out.println(this.name + "已到达.");
        try {
            this.cyclicBarrier.await();
            doMeeting();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void goToWork(){
        System.out.println(this.name + "开着" + this.car + "去上班.");
        try {
            long millis = (long)(Math.random() * 10 * 1000);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doMeeting(){
        System.out.println(this.name +  "say: 人都到齐了, 我们自己开会.然后努力工作");
    }
}