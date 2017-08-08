package ai.code.mikasa.template_method;

/**
 * Created by lenn on 16/4/21.
 */
public abstract class EatOutside {

    // 模版方法
    public void eatSomething(){
        waiter();
        order();
        checkout();
    }

    // 基本方法
    public void waiter(){
        System.out.println("叫服务员.");
    }

    public abstract void order();

    // 结账
    public void checkout(){
        System.out.println("结账");
    }
}
