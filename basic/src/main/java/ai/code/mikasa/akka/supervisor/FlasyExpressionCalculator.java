package ai.code.mikasa.akka.supervisor;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ai.code.mikasa.akka.supervisor.FlasyExpressionCalculator.Position.Left;
import static ai.code.mikasa.akka.supervisor.FlasyExpressionCalculator.Position.Right;
import ai.code.mikasa.akka.supervisor.AbstractExpression.*;

public class FlasyExpressionCalculator extends AbstractLoggingActor {

    public enum Position {
        Left, Right
    }

    public static final class Result {
        private final Expression expression;

        private final Integer value;

        private final Position position;

        public Result(Expression expression, Integer value, Position position) {
            this.expression = expression;
            this.value = value;
            this.position = position;
        }
    }

    private final Expression expr;

    private final Position myPosition;

    Set<Position> expected = Stream.of(Left, Right).collect(Collectors.toSet());
    Map<Position, Result> results = new HashMap<>();

    public FlasyExpressionCalculator(Expression expr, Position myPosition) {
        this.expr = expr;
        this.myPosition = myPosition;
    }

    public static Props props(Expression expr, Position myPosition){
        return Props.create(FlasyExpressionCalculator.class, expr, myPosition);
    }

    @Override
    public void preStart(){
        if(expr instanceof Const){
            Integer value = ((Const)expr).getValue();
            context().parent().tell(new Result(expr, value, myPosition), self());
            context().stop(self());
        }else {
            context().actorOf(FlasyExpressionCalculator.props(expr.getLeft(), Left), "left");
            context().actorOf(FlasyExpressionCalculator.props(expr.getRight(), Right), "right");
        }
    }

    @Override
    public Receive createReceive(){
        return receiveBuilder()
                .match(Result.class, r -> expected.contains(r.position), r -> {
                    expected.remove(r.position);
                    results.put(r.position, r);
                    if(results.size() == 2){
                        Integer value = calculate(expr, results.get(Left).value, results.get(Right).value);
                        System.out.println("============= " + value);
                        context().parent().tell(new Result(expr, value, myPosition), self());
                        context().stop(self());
                    }
                })
                .build();
    }

    private Integer calculate(Expression expr, Integer left, Integer right){
        if(expr instanceof Add){
            return left + right;
        }else if(expr instanceof Multiply){
            return left * right;
        }else if(expr instanceof Divide){
            return left / right;
        }else {
            throw new RuntimeException("不合法的算术操作");
        }
    }

}
