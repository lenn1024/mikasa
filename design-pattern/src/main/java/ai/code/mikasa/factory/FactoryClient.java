package ai.code.mikasa.factory;


import ai.code.mikasa.factory.product.Product;

/**
 * Created by lenn on 16/4/14.
 */
public class FactoryClient {
    public static void main(String[] args){
        /**
         * 简单工厂模式
         */
        SimpleProductFactory simpleProductFactory = new SimpleProductFactory();
        // 生产一个产品A
        Product a = simpleProductFactory.produce("A");
        // 生产一个产品B
        Product b = simpleProductFactory.produce("B");
        // 显示产品类型
        a.displayType();
        b.displayType();

        /**
         * 多个工厂方法模式
         */
        MultiMethodFactory multiMethodFactory = new MultiMethodFactory();
        Product a1 = multiMethodFactory.productA();
        Product b1 = multiMethodFactory.produceB();
        a1.displayType();
        b1.displayType();

        /**
         * 静态工厂模式
         */
        Product a2 = StaticFactory.productA();
        Product b2 = StaticFactory.produceB();
        a2.displayType();
        b2.displayType();
    }
}
