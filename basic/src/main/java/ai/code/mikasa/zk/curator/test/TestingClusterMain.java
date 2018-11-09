package ai.code.mikasa.zk.curator.test;

import org.apache.curator.test.TestingCluster;
import org.apache.curator.test.TestingZooKeeperServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestingClusterMain {
    private static Logger logger = LoggerFactory.getLogger(TestingClusterMain.class);

    public static void main(String[] args){
        TestingCluster cluster = new TestingCluster(3);
        try {
            cluster.start();
            Thread.sleep(3000);

            TestingZooKeeperServer leader = null;
            for(TestingZooKeeperServer server: cluster.getServers()){
                logger.info("server id: {}", server.getInstanceSpec().getServerId());
                logger.info("server quorumPeer: {}", server.getQuorumPeer().getServerState());
                logger.info("absolute path: {}", server.getInstanceSpec().getDataDirectory().getAbsolutePath());
                if(server.getQuorumPeer().getServerState().equals("leading")){
                    leader = server;
                }
            }
            leader.kill();

            logger.info("After leader is killed.");
            for(TestingZooKeeperServer server: cluster.getServers()){
                logger.info("server id: {}", server.getInstanceSpec().getServerId());
                logger.info("server quorumPeer: {}", server.getQuorumPeer().getServerState());
                logger.info("absolute path: {}", server.getInstanceSpec().getDataDirectory().getAbsolutePath());
            }

            cluster.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
