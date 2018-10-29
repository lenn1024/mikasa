package ai.code.mikasa.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class LeaderLatchMain {
    private static Logger logger = LoggerFactory.getLogger(LeaderLatchMain.class);

    public static void main(String[] args) throws Exception {
        List<CuratorFramework> clients = new ArrayList<>(5);
        List<LeaderLatch> leaderLatches = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            // 创建客户端
            CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new ExponentialBackoffRetry(1000, 3));
            clients.add(client);
            client.start();

            LeaderLatch leaderLatch = new LeaderLatch(client, "/leader", "client#" + i);
            leaderLatch.addListener(new LeaderLatchListener() {
                @Override
                public void isLeader() {
                    logger.info("I am a leader.");
                }

                @Override
                public void notLeader() {
                    logger.info("I am a follower.");
                }
            });
            leaderLatches.add(leaderLatch);
        }

        leaderLatches.stream().forEach(leaderLatch -> {
            new Thread(() -> {
                try {
                    leaderLatch.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        });
        Thread.sleep(10000);
        leaderLatches.stream().forEach(leaderLatch -> System.out.println(leaderLatch.hasLeadership()));
    }
}
