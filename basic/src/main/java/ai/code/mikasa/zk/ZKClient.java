package ai.code.mikasa.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZKClient{

    Logger logger = LoggerFactory.getLogger(ZKClient.class);

    /**
     * 连接字符串
     */
    private String connStr;
    /**
     * 会话超时时间
     */
    private int sessionTimeout;

    /**
     * 连接获取到的zk实例
     */
    private ZooKeeper zkInstance;

    public ZKClient(String connStr, int sessionTimeout) {
        this.connStr = connStr;
        this.sessionTimeout = sessionTimeout;
    }

    public ZooKeeper getZkInstance() {
        return zkInstance;
    }

    /**
     * 异步连接到zookeeper server
     * @throws IOException
     * @throws InterruptedException
     */
    public void connect() throws IOException, InterruptedException {
        logger.info("start connect zk server. connect string: {}.", connStr);
        // 栅栏
        CountDownLatch countDownLatch = new CountDownLatch(1);

        this.zkInstance = new ZooKeeper(connStr, sessionTimeout, event -> {
            if(event.getState() == Watcher.Event.KeeperState.SyncConnected){
                logger.info("connected zk server.");
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();
    }

    /**
     * 创建永久node节点
     * @param path
     * @param data
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void create(String path, byte[] data) throws KeeperException, InterruptedException {
        zkInstance.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     * 创建临时node节点
     * @param path
     * @param data
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void createTemporaryNode(String path, byte[] data) throws KeeperException, InterruptedException {
        zkInstance.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
    }

    /**
     * 获取某一路径的所有子节点
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public List<String> getChildren(String path) throws KeeperException, InterruptedException {
        return zkInstance.getChildren(path, false);
    }

    /**
     *
     * @param path
     * @param watch
     * @param stat
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public byte[] getData(String path, boolean watch, Stat stat) throws KeeperException, InterruptedException {
        return zkInstance.getData(path, watch, stat);
    }

    /**
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void delete(String path) throws KeeperException, InterruptedException {
        zkInstance.delete(path, -1);
    }

    public static void main(String[] args){
        ZKClient zkClient = new ZKClient("127.0.0.1:2181", 5000);
        try {
            // connect
            zkClient.connect();
            // getChildren
            List<String> nodes = zkClient.getChildren("/");
            nodes.forEach(node -> System.out.println(node));

            // get data
            Stat stat = new Stat();
            zkClient.getData("/test", false, stat);
            System.out.println(stat);

            // delete node
            zkClient.delete("/lenn/node1");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }
}
