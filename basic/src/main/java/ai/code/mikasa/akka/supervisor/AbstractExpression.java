package ai.code.mikasa.akka.supervisor;

public abstract class AbstractExpression implements Expression{
    private final Expression left;

    private final Expression right;

    private final String operator;

    public AbstractExpression(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public Expression getLeft() {
        return left;
    }

    @Override
    public Expression getRight() {
        return right;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return  "(" + getLeft() + " " + operator + " " + getRight() + ")";
    }

    public static final class Add extends AbstractExpression {
        public Add(Expression left, Expression right) {
            super(left, right, "+");
        }
    }

    public static final class Multiply extends AbstractExpression {
        public Multiply(Expression left, Expression right) {
            super(left, right, "*");
        }
    }

    public static final class Divide extends AbstractExpression {
        public Divide(Expression left, Expression right) {
            super(left, right, "/");
        }
    }


}
