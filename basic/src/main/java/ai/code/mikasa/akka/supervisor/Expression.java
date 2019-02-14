package ai.code.mikasa.akka.supervisor;

/**
 * 计算表达式接口
 */
public interface Expression {
    /**
     * 获取左侧计算表达式
     * @return
     */
    Expression getLeft();

    /**
     * 获取右侧计算表达式
     * @return
     */
    Expression getRight();
}
