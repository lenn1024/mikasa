package ai.code.mikasa.akka.supervisor;

public final class Const implements Expression {
    private final int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public Expression getLeft() {
        return this;
    }

    @Override
    public Expression getRight() {
        return this;
    }

    public int getValue() {
        return value;
    }
}
