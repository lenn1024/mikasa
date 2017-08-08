package ai.code.mikasa.advanced.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lenn on 17/4/27.
 */
public class Employee implements Runnable {
    private String name;
    private String car;
    private CountDownLatch countDownLatch;

    public Employee(String name, String car, CountDownLatch countDownLatch) {
        this.name = name;
        this.car = car;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        goToWork();
        System.out.println(this.name + "已到达.");
        this.countDownLatch.countDown();
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
}