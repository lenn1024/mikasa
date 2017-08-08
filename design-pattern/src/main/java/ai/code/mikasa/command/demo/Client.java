package ai.code.mikasa.command.demo;

import java.util.List;

/**
 * Created by lenn on 16/11/27.
 */
public class Client {
    public static void main(String[] args){
        Waiter waiter = new Waiter();

        Customer customer = new Customer();
        // 点菜
        Order order = customer.createOrder();
        // 服务员接受订单, 交给厨师做饭
        List<Food> foods = waiter.takeOrder(order);

        System.out.println("开动吃饭了...");
    }
}
