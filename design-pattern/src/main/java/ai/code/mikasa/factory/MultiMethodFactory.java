package ai.code.mikasa.factory;

import ai.code.mikasa.factory.product.Product;
import ai.code.mikasa.factory.product.ProductA;
import ai.code.mikasa.factory.product.ProductB;

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
