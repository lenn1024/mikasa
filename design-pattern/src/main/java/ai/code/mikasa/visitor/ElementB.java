package ai.code.mikasa.visitor;

/**
 * Created by lenn on 16/10/21.
 */
public class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
