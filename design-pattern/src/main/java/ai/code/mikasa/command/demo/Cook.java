package ai.code.mikasa.command.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenn on 16/11/27.
 * 厨师类
 */
public class Cook {
    /**
     * 做料理
     * @param order
     */
    public List<Food> cook(Order order){
        List<Food> foods = new ArrayList<>();
        System.out.println("cooking some food...");
        // ...

        return foods;
    }
}
