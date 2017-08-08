package ai.code.mikasa.template_method;

/**
 * Created by lenn on 16/4/21.
 */
public class EatInBigRestaurant extends EatOutside {
    public EatInBigRestaurant() {
        super();
    }

    @Override
    public void order() {
        System.out.println("点满汉全席");
    }
}
