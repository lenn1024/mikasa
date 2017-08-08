package ai.code.mikasa.decorator;

/**
 * Created by lenn on 16/4/14.
 *  具体装饰类
 */
public class DecoratorB extends Decorator {


    public DecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        getComponent().operation();
        // 在component执行完方法之后再执行装饰者B的方法
        operationOne();
    }

    public void operationOne(){
        System.out.println("穿上裙子.");
    }
}
