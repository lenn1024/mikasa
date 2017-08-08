package ai.code.mikasa.decorator;

/**
 * Created by lenn on 16/4/14.
 * 抽象装饰者:持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。
 */
public abstract class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }
}
