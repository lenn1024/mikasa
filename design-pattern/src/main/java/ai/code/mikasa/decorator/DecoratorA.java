package ai.code.mikasa.decorator;

/**
 * Created by lenn on 16/4/14.
 * 具体装饰类
 */
public class DecoratorA extends Decorator {

    // 构造函数
    public DecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        // 在被装饰者执行动作之前,执行一系列装饰者的方法.
        operationOne();
        getComponent().operation();

    }

    public void operationOne(){
        System.out.println("穿上内裤.");
    }
}
