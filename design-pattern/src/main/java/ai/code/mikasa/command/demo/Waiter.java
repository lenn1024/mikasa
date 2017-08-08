package ai.code.mikasa.command.demo;

import java.util.List;

/**
 * Created by lenn on 16/11/27.
 */
public class Waiter {
    /**
     * 服务员接受订单交给厨师去做饭
     * @param order
     * @return
     */
    public List<Food> takeOrder(Order order){
        Cook cook = new Cook();
        List<Food> foods = cook.cook(order);
        System.out.println("take some time...,food is ok.");
        return foods;
    }
}
