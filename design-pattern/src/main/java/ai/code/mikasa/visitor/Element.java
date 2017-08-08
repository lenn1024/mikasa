package ai.code.mikasa.visitor;

/**
 * Created by lenn on 16/10/21.
 */
public interface Element {
    void accept(Visitor visitor);
}
