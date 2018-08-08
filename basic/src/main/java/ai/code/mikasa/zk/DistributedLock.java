package ai.code.mikasa.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class DistributedLock {
    private String root;

    private String lockName;

    private ZKClient zkClient;

    public DistributedLock(String root, String lockName, ZKClient zkClient) throws IOException, InterruptedException, KeeperException {
        this.root = root;
        this.lockName = lockName;
        this.zkClient = zkClient;
        zkClient.connect();
        ensureRoot();
    }

    /**
     * 确保root路径存在
     * @throws KeeperException
     * @throws InterruptedException
     */
    private void ensureRoot() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists(this.root);
        if(stat == null){
            zkClient.getZkInstance().create(root, "locks".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }


    public void tryLock() throws KeeperException, InterruptedException {
        String path = root + "/" + lockName;
        String lockNode = zkClient.getZkInstance().create(path, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

        List<String> lockNodes = zkClient.getZkInstance().getChildren(root, false);

    }

}
