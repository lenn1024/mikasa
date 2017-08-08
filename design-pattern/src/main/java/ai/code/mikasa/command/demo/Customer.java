package ai.code.mikasa.command.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenn on 16/11/27.
 */
public class Customer {
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * 点菜
     * @return
     */
    public Order createOrder(){
        System.out.println("create an order...");
        Order order = new Order();

        List<String> foods = new ArrayList<>();
        foods.add("馒头");
        foods.add("青椒肉丝");

        order.setFood(foods);

        this.order = order;

        return order;
    }
}
