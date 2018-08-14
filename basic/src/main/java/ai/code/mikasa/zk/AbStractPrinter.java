package ai.code.mikasa.zk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbStractPrinter implements Printable {
    Logger logger = LoggerFactory.getLogger(AbStractPrinter.class);

    public void print(String msg){
        String threadName = Thread.currentThread().getName();
        logger.info("Thread[{}]: {}.", threadName, msg);
    }
}
