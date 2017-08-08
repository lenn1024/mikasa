package ai.code.mikasa.advanced.concurrent.threadpool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenn on 16/7/4.
 */
public class MyThreadPool {
    public static void main(String[] args){

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));

        threadPool.execute(new Thread(){
            @Override
            public void run(){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am a task.");
            }
        });

        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        new ArrayList<String>();
    }
}
