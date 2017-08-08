package ai.code.mikasa.factory;


import waw.sakura.dp.factory.product.Product;
import waw.sakura.dp.factory.product.ProductA;
import waw.sakura.dp.factory.product.ProductB;

/**
 * Created by lenn on 16/4/14.
 * 静态工厂模式
 * 静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 */
public class StaticFactory {
    public static Product productA(){
        return new ProductA();
    }

    public static Product produceB(){
        return new ProductB();
    }
}
