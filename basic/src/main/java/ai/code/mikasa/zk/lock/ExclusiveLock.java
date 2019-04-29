package ai.code.mikasa.zk.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.KeeperException.NodeExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * 利用ZK实现一个排它锁
 */
public class ExclusiveLock {

    private static Logger logger = LoggerFactory.getLogger(ExclusiveLock.class);

    /**
     * 锁的路径
     */
    private static String LockRootPath = "/locks/exclusive";

    /**
     * 锁名字
     */
    private String lockName;

    /**
     * zk client
     */
    private ZKClient zkClient;

    /**
     * 是否初始化完毕
     */
    private boolean isInited;

    /**
     * 同步控制
     */
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * 是否拥有锁
     */
    private boolean isOwnLock;

    // constructor
    public ExclusiveLock(ZKClient zkClient, String lockName) {
        Objects.requireNonNull(zkClient);
        Objects.requireNonNull(lockName);
//        Objects.requireNonNull(countDownLatch);

        this.zkClient = zkClient;
        this.lockName = lockName;
//        this.countDownLatch = countDownLatch;
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException, InterruptedException {
        this.zkClient.connect();
        this.isInited = true;
    }

    /**
     * 加锁操作
     */
    public void lock() {
        if(!isInited){
            throw new IllegalStateException("未初始化。");
        }

        String lockPath = getLockPath();
        try {
            String path = this.zkClient.getZkInstance().create(lockPath, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            isOwnLock = true;
            logger.info(Thread.currentThread().getName() + ": 抢占锁成功.");
        } catch (KeeperException e) {
            // 若锁已被其他线程占用
            if(e.code() == NodeExistsException.Code.NODEEXISTS){
                logger.info("lock path: {} 已存在，该排他锁已被抢占，阻塞当前线程。", lockPath);
                try {
                    this.zkClient.getZkInstance().exists(lockPath, new NodeDeleteWatcher());
                } catch (KeeperException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                try {
                    countDownLatch.await();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }else {
                logger.error("抢占锁异常。", e);
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            logger.error("抢占锁异常。", e);
            e.printStackTrace();
        }
    }

    /**
     * 解锁
     */
    public void unLock(){
        if(!isOwnLock){
            throw new IllegalStateException(getThreadName() + " - Illegal Operation: can not unlock the lock if this t1 does not own the lock.");
        }

        try {
            logger.info(getThreadName() + ": 释放分布式锁.");
            this.zkClient.getZkInstance().delete(getLockPath(), -1);
            this.zkClient.getZkInstance().close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取锁的全路径名
     * @return
     */
    public String getLockPath(){
        return ExclusiveLock.LockRootPath + "/" + this.lockName;
    }

    private String getThreadName(){
        return Thread.currentThread().getName();
    }


    class NodeDeleteWatcher implements Watcher{
        @Override
        public void process(WatchedEvent event) {
            if(event.getType() == Watcher.Event.EventType.NodeDeleted){
                try {
                    // 再次尝试加锁
                    zkClient.getZkInstance().create(getLockPath(), "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                    logger.info(getThreadName() + " 抢占锁成功.");
                    countDownLatch.countDown();
                    isOwnLock = true;
                } catch (KeeperException e1) {
                    // Watcher注册只能确保一次消费
                    // e1.printStackTrace();
                    if(e1.code() == NodeExistsException.Code.NODEEXISTS){
                        logger.info(getThreadName() + ": 锁已被抢占，等待下次再抢。");
                        try {
                            zkClient.getZkInstance().exists(getLockPath(), new NodeDeleteWatcher());
                        } catch (KeeperException e2) {
                            e1.printStackTrace();
                        } catch (InterruptedException e2) {
                            e1.printStackTrace();
                        }
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
