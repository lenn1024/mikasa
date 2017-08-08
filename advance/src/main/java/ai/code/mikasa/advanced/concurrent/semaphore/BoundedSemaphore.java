package ai.code.mikasa.advanced.concurrent.semaphore;

/**
 * Created by lenn on 16/7/4.
 * 可计数的,有上限的信号量
 */
public class BoundedSemaphore {
    private int signal = 0;
    private int bounded = 0;

    public void BoundedSemaphore(int upperBound){
        this.bounded = upperBound;
    }

    public synchronized void take() throws InterruptedException {
        if(this.signal == this.bounded){
            this.wait();
        }
        this.signal++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (this.signal == 0){
            this.wait();
        }

        this.signal--;
    }
}
