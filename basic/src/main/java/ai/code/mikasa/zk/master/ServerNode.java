package ai.code.mikasa.zk.master;

import ai.code.mikasa.zk.Printable;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ServerNode implements Printable {

    private Logger logger = LoggerFactory.getLogger(ServerNode.class);

    private static final String DEFAULT_ROOT_PATH = "/cluster/master";

    private static final String DEFAULT_MASTER_NODE_NAME = "serverNode";


    /**
     * server id
     */
    private long serverId;

    /**
     * server name
     */
    private String serverName;

    /**
     * 是否为master
     */
    private boolean isMaster;

    /**
     * ZK client
     */
    private ZooKeeper zkClient;

    /**
     * ZK root path
     */
    private String rootPath;

    /**
     * 选举master节点名
     */
    private String masterNodeName;

    /**
     * 当前节点的path
     */
    private String nodePath;


    public ServerNode(long serverId, String serverName, ZooKeeper zkClient) {
        this(serverId, serverName, zkClient, DEFAULT_ROOT_PATH, DEFAULT_MASTER_NODE_NAME);
    }

    public ServerNode(long serverId, String serverName, ZooKeeper zkClient, String rootPath, String masterNodeName) {
        Objects.requireNonNull(zkClient);
        Objects.requireNonNull(rootPath);
        Objects.requireNonNull(masterNodeName);

        this.serverId = serverId;
        this.serverName = serverName;
        this.zkClient = zkClient;
        this.rootPath = rootPath;
        this.masterNodeName = masterNodeName;
    }

    public long getServerId() {
        return serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public boolean isMaster() {
        return isMaster;
    }

    public String getRootPath() {
        return rootPath;
    }

    /**
     * 确保root path已存在，否则抛异常
     */
    private void ensureRootPath(){
        try {
            Stat stat = zkClient.exists(rootPath, false);
            if(stat == null){
                logger.error("zk server root path does not exists:{}.", rootPath);
                throw new IllegalStateException("zk path does not exists.");
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getMasterPath(){
        return rootPath + "/" + masterNodeName;
    }

    public void vote() throws KeeperException, InterruptedException {
        print("start vote.");
        // 确保根路径存在
        ensureRootPath();

        byte[] serverIdInfo = String.valueOf(serverId).getBytes();
        String masterPath = getMasterPath();
        nodePath = zkClient.create(masterPath, serverIdInfo, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        if(isZkMaster()){
            isMaster = true;
            zkClient.setData(rootPath, serverIdInfo, -1);
        }
    }

    public boolean isZkMaster() throws KeeperException, InterruptedException {
        print("judge if this node becomes the master.");
        List<String> childrenNodes = zkClient.getChildren(getRootPath(), new ChildrenChangedWatcher());
        Collections.sort(childrenNodes);
        if(nodePath.equals(rootPath + "/" + childrenNodes.get(0))){
            print("is the master.");
            return true;
        }
        print("is the slave.");
        return false;
    }

    @Override
    public void print(String msg) {
        String threadName = Thread.currentThread().getName();
        logger.info("Thread[{}]: {}.", threadName, msg);
    }

    /**
     * 子节点变更Watcher
     */
    class ChildrenChangedWatcher implements Watcher{

        @Override
        public void process(WatchedEvent event) {
            if(event.getType() == Event.EventType.NodeChildrenChanged
                    && event.getState() == Event.KeeperState.SyncConnected){
                try {
                    if(isZkMaster()){
                        print("have became the master.");
                        isMaster = true;
                        zkClient.setData(rootPath, String.valueOf(serverId).getBytes(), -1);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
