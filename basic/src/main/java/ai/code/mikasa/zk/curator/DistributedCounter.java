package ai.code.mikasa.zk.curator;


import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 分布式计数器
 */
public class DistributedCounter {
    private static Logger logger = LoggerFactory.getLogger(DistributedCounter.class);
    private static String path = "/dist_counter";

    public static void main(String[] args){
        CuratorMain instance = new CuratorMain();
        instance.buildClient();
        instance.getClient();

        DistributedAtomicInteger distCounter = new DistributedAtomicInteger(instance.getClient(), path, new RetryNTimes(3, 1000));
        try {
            AtomicValue<Integer> rc = distCounter.add(3);
            logger.info("Result: {}", rc.postValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
