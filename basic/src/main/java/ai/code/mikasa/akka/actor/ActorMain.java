package ai.code.mikasa.akka.actor;

import ai.code.mikasa.akka.Greet;
import ai.code.mikasa.akka.Greeting;
import ai.code.mikasa.akka.WhoToGreet;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeoutException;

public class ActorMain {
    private static final Logger logger = LoggerFactory.getLogger(ActorMain.class);

    public static void main(String[] args) throws TimeoutException {
        inboxTest();

        final ActorSystem system = ActorSystem.create("helloakka");
        logger.info("actor system log level is " + system.settings().LogLevel());
    }

    public static void simpleTest(){
        final ActorSystem system = ActorSystem.create("helloakka");
        final ActorRef greeter = system.actorOf(Props.create(Greeter.class), "greeter");
        greeter.tell(new WhoToGreet("akka"), ActorRef.noSender());
        greeter.tell(new Greet(), ActorRef.noSender());
        greeter.tell(new Object(), ActorRef.noSender());
    }

    public static void inboxTest() throws TimeoutException {
        final ActorSystem system = ActorSystem.create("helloakka");
        final ActorRef greeter = system.actorOf(Props.create(Greeter.class), "greeter");

        greeter.tell(new WhoToGreet("akka"), ActorRef.noSender());

        final Inbox inbox = Inbox.create(system);
        inbox.send(greeter, new Greet());
        Greeting greeting = (Greeting)inbox.receive(Duration.create(5, "seconds"));

        logger.info("receive message: {}.", greeting);
    }
}
