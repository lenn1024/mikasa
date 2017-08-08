package ai.code.mikasa.advanced.concurrent;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lenn on 16/7/4.
 */
public class BlockingQueue {
    private List queue = new LinkedList();
    private int limit;

    public BlockingQueue(int limit){
        this.limit = limit;
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        while (this.limit == queue.size()){
            this.wait();
        }

        queue.add(item);
        this.notifyAll();
    }

    public synchronized void dequeue() throws InterruptedException {
        while (queue.size() == 0){
            this.wait();
        }

        queue.remove(0);
        this.notifyAll();
    }

}
