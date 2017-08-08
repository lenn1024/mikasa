package ai.code.mikasa.factory;

import waw.sakura.dp.factory.product.Product;
import waw.sakura.dp.factory.product.ProductA;
import waw.sakura.dp.factory.product.ProductB;

/**
 * Created by lenn on 16/4/14.
 * 简单工厂,也叫做普通工厂
 * 普通工厂模式就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 */
public class SimpleProductFactory {
    public Product produce(String type){
        Product product = null;
        switch (type){
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
                break;
            default:break;
        }
        return product;
    }
}
