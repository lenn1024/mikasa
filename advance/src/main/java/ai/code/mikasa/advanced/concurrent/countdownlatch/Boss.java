package ai.code.mikasa.advanced.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lenn on 17/4/27.
 */
public class Boss implements Runnable {
    private String name;
    private CountDownLatch countDownLatch;

    public Boss(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        try {
            this.countDownLatch.await();
            doMeeting();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doMeeting(){
        System.out.println("人都到齐了,我们开会吧.");
    }
}
