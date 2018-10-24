package ai.code.mikasa.akka.actor;

import ai.code.mikasa.akka.Greet;
import ai.code.mikasa.akka.Greeting;
import ai.code.mikasa.akka.WhoToGreet;
import akka.actor.UntypedActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Greeter extends UntypedActor {
    private static Logger logger = LoggerFactory.getLogger(Greeter.class);

    String greeting = "";

    public void onReceive(Object message) {

        if (message instanceof WhoToGreet){
            greeting = "hello, " + ((WhoToGreet) message).who;
            logger.info("set greeting msg: {}.", greeting);
        } else if (message instanceof Greet){
            getSender().tell(new Greeting(greeting), getSelf());
            logger.info("tell ....");
        } else {
            logger.info("unhandled message.");
            unhandled(message);
        }
    }
}
