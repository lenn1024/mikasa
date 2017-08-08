package ai.code.mikasa.state;

/**
 * Created by lenn on 16/12/4.
 */
public interface State {
    // 投入硬币
    void insertQuarter();
    // 退回硬币
    void ejectQuarter();
    // 转动曲柄
    void turnCrank();
    // 发放糖果
    void dispense();
}
