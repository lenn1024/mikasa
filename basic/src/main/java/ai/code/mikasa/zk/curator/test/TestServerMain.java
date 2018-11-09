package ai.code.mikasa.zk.curator.test;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;

public class TestServerMain {
    public static void main(String[] args){
        try {
            TestingServer testingServer = new TestingServer(2181);
            CuratorFramework client = CuratorFrameworkFactory.builder()
                    .connectionTimeoutMs(10000)
                    .connectString("127.0.0.1:2181")
                    .sessionTimeoutMs(5000)
                    .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                    .build();
            client.start();
            System.out.println("=====" + client.getChildren().forPath("/zookeeper"));
            testingServer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
