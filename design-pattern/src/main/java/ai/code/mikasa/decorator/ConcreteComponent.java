package ai.code.mikasa.decorator;

/**
 * Created by lenn on 16/4/14.
 * 具体构件: 实现operation方法
 */
public class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("穿一条裤子.");
    }
}
