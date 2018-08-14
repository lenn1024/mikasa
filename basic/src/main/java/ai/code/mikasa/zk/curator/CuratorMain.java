package ai.code.mikasa.zk.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.List;

public class CuratorMain {
    public static void main(String[] args){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", 5000, 3000, retryPolicy);
        client.start();
        try {
            List<String> childrenNodes = client.getChildren().forPath("/");
            childrenNodes.stream()
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();
    }
}
