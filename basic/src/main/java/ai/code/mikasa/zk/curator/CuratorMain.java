package ai.code.mikasa.zk.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CuratorMain {
    private static Logger logger = LoggerFactory.getLogger(CuratorMain.class);

    private CuratorFramework client;

    public static void main(String[] args){
        CuratorMain instance = new CuratorMain();
        instance.buildClient();
         //instance.create("/beijing", "a good city");
         //instance.delete("/guangzhou");
        instance.getData("/beijing");
        instance.setData("/guangzhou", "a better city.");
        instance.close();
    }

    public void buildClient(){
        logger.info("创建curator 客户端.");
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .connectionTimeoutMs(1000)
                .sessionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .namespace("mikasa")
                .build();
        client.start();
    }

    public void create(String path, String data){
        logger.info("创建节点: {}({}).", path, data);
        try {
            client.create()
                    // 通过creatingParentsIfNeeded方法Curator可以递归创建所需父节点
                    .creatingParentsIfNeeded()
                    // 指定创建节点的类型
                    .withMode(CreateMode.PERSISTENT)
                    .forPath(path, data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getData(String path){
        Stat stat = new Stat();
        String data = null;
        try {
            data = new String(client.getData()
                    .storingStatIn(stat)
                    .forPath(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("获取到数据内容：{}，Stat: {}.", data, stat);
        return data;
    }

    public void setData(String path, String data){
        try {
            Stat stat = new Stat();
            client.getData().storingStatIn(stat).forPath(path);
            client.setData()
                    // withVersion接口实现CAS
                    .withVersion(stat.getVersion())
                    .forPath(path, data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String path){
        logger.info("删除节点：{}.", path);
        try {
            client.delete()
                    // 通过deletingChildrenIfNeeded方法可以递归删除所有子节点
                    .deletingChildrenIfNeeded()
                    .forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close(){
        client.close();
    }

    public CuratorFramework getClient() {
        return client;
    }
}
