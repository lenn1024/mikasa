package ai.code.mikasa.visitor;

/**
 * Created by lenn on 16/10/21.
 */
public interface Visitor {
    void visit(ElementA e);
    void visit(ElementB e);
}
