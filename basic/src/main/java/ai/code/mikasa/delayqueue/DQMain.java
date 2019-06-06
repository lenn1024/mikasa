package ai.code.mikasa.delayqueue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;

public class DQMain {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedObject> delayQueue = new DelayQueue<>();

        delayQueue.offer(new DelayedObject(5000, "5s"));
        delayQueue.offer(new DelayedObject(3000, "3s"));

        while (true){
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "   " + delayQueue.take());
        }
    }
}
