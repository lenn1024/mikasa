package ai.code.mikasa.akka.best;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Creator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BestActor extends UntypedActor {
    private static Logger logger = LoggerFactory.getLogger(BestActor.class);

    private int x;
    private int y;

    public BestActor(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Props props(final int x, final int y){
        return Props.create(new Creator<BestActor>() {
            @Override
            public BestActor create() throws Exception {
                return new BestActor(x, y);
            }
        });
    }

    @Override
    public void onReceive(Object o) throws Exception {
        logger.info("{} receive msg:{}.", this.getClass().getSimpleName(), o);
        Integer result = x + y;
        getSender().tell(result, getSelf());
        getContext().stop(getSelf());
    }
}
