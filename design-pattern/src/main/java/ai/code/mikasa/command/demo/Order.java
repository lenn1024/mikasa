package ai.code.mikasa.command.demo;

import java.util.List;

/**
 * Created by lenn on 16/11/27.
 */
public class Order {
    private List<String> food;

    public Order() {}

    public List<String> getFood() {
        return food;
    }

    public void setFood(List<String> food) {
        this.food = food;
    }
}
