package ai.code.mikasa.factory;

import waw.sakura.dp.factory.product.Product;
import waw.sakura.dp.factory.product.ProductA;
import waw.sakura.dp.factory.product.ProductB;

/**
 * Created by lenn on 16/4/14.
 * 多个工厂方法模式
 * 多个工厂方法模式，是对普通工厂方法模式的改进，多个工厂方法模式就是提供多个工厂方法，分别创建对象。
 */
public class MultiMethodFactory {
    public Product productA(){
        return new ProductA();
    }

    public Product produceB(){
        return new ProductB();
    }
}
