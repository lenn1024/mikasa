package ai.code.mikasa.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
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
    private CountDownLatch countDownLatch;

    // constructor
    public ExclusiveLock(ZKClient zkClient, String lockName, CountDownLatch countDownLatch) {
        Objects.requireNonNull(zkClient);
        Objects.requireNonNull(lockName);
        Objects.requireNonNull(countDownLatch);

        this.zkClient = zkClient;
        this.lockName = lockName;
        this.countDownLatch = countDownLatch;
    }

    public void init() throws IOException, InterruptedException {
        this.zkClient.connect();
        this.isInited = true;
    }

    public void lock(){
        if(!isInited){
            throw new IllegalStateException("未初始化。");
        }

        try {
            this.zkClient.getZkInstance().create(getLockPath(), "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (KeeperException e) {
            logger.error("创建锁异常。", e);
            e.printStackTrace();
        } catch (InterruptedException e) {
            logger.error("创建锁异常。", e);
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
}
