package ai.code.mikasa.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeaderLatchMain {
    private static Logger logger = LoggerFactory.getLogger(LeaderLatchMain.class);

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new ExponentialBackoffRetry(1000, 3));
        client.start();

        LeaderLatch leaderLatch = new LeaderLatch(client, "/leader", "client1");
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
        leaderLatch.start();

        leaderLatch.await();
    }
}
