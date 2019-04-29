package test.t1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool {
    private BlockingQueue<Runnable> queue;

    private List<PoolThread> threads;

    public ThreadPool(int noOfThreads, int maxNoOfTasks){
        this.queue = new ArrayBlockingQueue<>(maxNoOfTasks);

        this.threads = new ArrayList<>();
        for(int i = 0; i < noOfThreads; i++){
            this.threads.add(new PoolThread(queue));
        }

        for(PoolThread poolThread: threads){
            poolThread.start();
        }
    }

    public void execute(Runnable task){
        this.queue.add(task);
    }

    public void stop(){
        for(PoolThread poolThread: threads){
            poolThread.toStop();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(2, 5);
        threadPool.execute(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("Start: 线程" + name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("睡眠被中断了。");
            }
            System.out.println("End: 线程" + name);
        });

        Thread.sleep(3000);
        threadPool.stop();


        ReentrantLock lock = new ReentrantLock();
        try {
            //  lock.tryLock(3, TimeUnit.SECONDS);
            lock.lock();
            Condition condition = lock.newCondition();


        }finally {
            lock.unlock();
        }
    }
}
