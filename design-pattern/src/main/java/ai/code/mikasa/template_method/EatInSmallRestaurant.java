package ai.code.mikasa.template_method;

/**
 * Created by lenn on 16/4/21.
 */
public class EatInSmallRestaurant extends EatOutside {

    public EatInSmallRestaurant() {
        super();
    }

    @Override
    public void order() {
        System.out.println("点一碗面");
    }
}
