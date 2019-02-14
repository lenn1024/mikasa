package ai.code.mikasa.akka.supervisor;

import ai.code.mikasa.akka.supervisor.AbstractExpression.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class SupervisorMain {
    public static void main(String[] args){
        Expression expression = new Add(new Const(5), new Const(3));

        ActorSystem actorSystem = ActorSystem.create("actorSystem");
        ActorRef actorRef = actorSystem.actorOf(FlasyExpressionCalculator.props(expression, FlasyExpressionCalculator.Position.Left), "calculator");

    }
}
