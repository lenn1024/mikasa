package ai.code.mikasa.akka.actor;

import ai.code.mikasa.akka.Greet;
import ai.code.mikasa.akka.WhoToGreet;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class ActorMain {
    public static void main(String[] args){
        final ActorSystem system = ActorSystem.create("helloakka");
        final ActorRef greeter = system.actorOf(Props.create(Greeter.class), "greeter");
        greeter.tell(new WhoToGreet("akka"), ActorRef.noSender());
        greeter.tell(new Greet(), ActorRef.noSender());
    }
}
