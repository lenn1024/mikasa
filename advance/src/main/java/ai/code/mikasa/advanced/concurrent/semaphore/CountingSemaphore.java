package ai.code.mikasa.advanced.concurrent.semaphore;

/**
 * Created by lenn on 16/7/4.
 * 可计数的信号量
 */
public class CountingSemaphore {
    private int signal = 0;

    public synchronized void take(){
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
