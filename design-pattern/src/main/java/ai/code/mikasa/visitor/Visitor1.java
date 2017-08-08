package ai.code.mikasa.visitor;

/**
 * Created by lenn on 16/10/21.
 */
public class Visitor1 implements Visitor {
    @Override
    public void visit(ElementA e) {
        System.out.println("visitor1 visit element a.");
    }

    @Override
    public void visit(ElementB e) {
        System.out.println("visitor1 visit element b.");
    }
}
