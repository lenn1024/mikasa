package ai.code.mikasa.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MasterSelector {
    private static Logger logger = LoggerFactory.getLogger(MasterSelector.class);

    public static void main(String[] args) throws InterruptedException {
        String masterPath = "/task_master";
        CuratorMain instance = new CuratorMain();
        instance.buildClient();
        CuratorFramework client = instance.getClient();

        LeaderSelector leaderSelector = new LeaderSelector(client, masterPath, new LeaderSelectorListenerAdapter() {
            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {
                logger.info("我成为了Master.");
                Thread.sleep(3000);
                logger.info("我完成了Master的操作，释放权利.");
            }
        });
        leaderSelector.autoRequeue();
        leaderSelector.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
