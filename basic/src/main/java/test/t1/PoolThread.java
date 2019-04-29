package test.t1;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread {

    private BlockingQueue<Runnable> queue;

    private boolean isStopped;

    public PoolThread(BlockingQueue<Runnable> queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        while (!isStopped){
            try {
                Runnable runnable = queue.take();
                runnable.run();
            } catch (InterruptedException e) {
                String name = Thread.currentThread().getName();
                System.out.println("线程" + name + "被中断了。");
            }
        }
    }

    public void toStop(){
        this.isStopped = true;
        this.interrupt();
    }
}
