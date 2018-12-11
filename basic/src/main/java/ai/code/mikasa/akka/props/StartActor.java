package ai.code.mikasa.akka.props;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartActor extends UntypedActor {
    private static Logger logger = LoggerFactory.getLogger(StartActor.class);

    @Override
    public void preStart(){
        final ActorRef child = getContext().actorOf(Props.create(SumActor.class, 5, 6), "child");
        child.tell("hi child.", getSelf());
    }

    @Override
    public void onReceive(Object o) throws Exception {
        logger.info("startActor receive msg:{}.", o);
        this.getContext().stop(getSelf());
    }
}
