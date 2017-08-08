package ai.code.mikasa.advanced.concurrent.semaphore;

/**
 * Created by lenn on 16/7/4.
 * 一个信号量的简单实现
 */
public class Semaphore {
    private boolean signal = false;

    public synchronized void take(){
        this.signal = true;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (!this.signal){
            this.wait();
        }
        this.signal = false;
    }
}
