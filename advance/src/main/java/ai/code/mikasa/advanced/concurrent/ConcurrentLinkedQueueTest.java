package ai.code.mikasa.advanced.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by lenn on 16/8/28.
 */
public class ConcurrentLinkedQueueTest {
    ThreadLocal<String> a;
    public static void main(String[] args){
       ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
       queue.offer("aa");
       queue.offer("bb");
       queue.offer("countdownlatch");
       System.out.println(queue.peek());
    }
}
