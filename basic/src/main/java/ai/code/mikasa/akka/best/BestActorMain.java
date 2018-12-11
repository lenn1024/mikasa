package ai.code.mikasa.akka.best;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Props
 *
 *
 */
public class BestActorMain {
    public static void main(String[] args){
        ActorSystem actorSystem = ActorSystem.create("bestSystem");
        actorSystem.actorOf(Props.create(StartActor.class), "startActor");
    }

    static class StartActor extends UntypedActor {
        private static Logger logger = LoggerFactory.getLogger(StartActor.class);

        @Override
        public void preStart(){
            ActorRef actorRef = getContext().actorOf(BestActor.props(4, 5), "child");
            actorRef.tell("Hello, child.", this.getSelf());
        }

        @Override
        public void onReceive(Object o) throws Exception {
            logger.info("{} receive msg: {}.", this.getClass().getSimpleName(), o);
            this.getContext().stop(getSender());
        }
    }
}
