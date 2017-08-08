package ai.code.mikasa.decorator;

/**
 * Created by lenn on 16/4/14.
 */

/**
 * 装饰者模式又名包装(Wrapper)模式。装饰者以对客户端透明的方式扩展对象的功能，是继承关系的一个替代方案。
 * 很好的诠释类对修改封闭,对扩展开发的原则
 */
public class DecoratorClient {
    public static void main(String args[]){
        // 创建一个具体构件对象
        Component component = new ConcreteComponent();

        // 创建两个具体的装饰者实例
        Decorator decoratorA = new DecoratorA(component);
        Decorator decoratorB = new DecoratorB(component);

        // 欢迎被A装饰后的component粉墨登场
        decoratorA.operation();

        // 欢迎被B装饰后的component粉墨登场
        decoratorB.operation();
    }
}
