package ai.code.mikasa.akka.props;

import akka.actor.UntypedActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SumActor extends UntypedActor {
    private static Logger logger = LoggerFactory.getLogger(SumActor.class);

    private int x;
    private int y;

    public SumActor(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void onReceive(Object o) throws Exception {
        logger.info("sumActor receive msg:{}.", o);
        Integer result = x + y;
        getSender().tell(result, getSelf());
        getContext().stop(getSelf());
    }
}
