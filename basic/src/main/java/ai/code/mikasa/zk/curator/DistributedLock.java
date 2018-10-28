package ai.code.mikasa.zk.curator;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class DistributedLock {
    private static Logger logger = LoggerFactory.getLogger(DistributedLock.class);

    private static String lockPath = "/distributed_lock";
    private static int count = 0;

    public static void main(String[] args){
        CuratorMain instance = new CuratorMain();
        instance.buildClient();
        InterProcessMutex lock = new InterProcessMutex(instance.getClient(), lockPath);

        CountDownLatch countDownLatch = new CountDownLatch(1);
        for(int i = 0; i < 30; i++){
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    lock.acquire();
                    logger.info("计数器目前值为：{}。", count++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        countDownLatch.countDown();
    }
}
