package ai.code.mikasa.advanced.concurrent;

/**
 * Created by lenn on 16/6/30.
 * 一个简单的锁,此锁不可重入
 */
public class SimpleLock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked){
            this.wait();
        }
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;
        this.notifyAll();
    }
}
