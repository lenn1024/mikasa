package ai.code.mikasa.template_method;

/**
 * Created by lenn on 16/4/21.
 */
public class TemplateMethodClient {
    public static void main(String[] args){
        EatOutside eatOne = new EatInSmallRestaurant();
        EatOutside eatTwo = new EatInBigRestaurant();

        // 在小餐馆吃
        System.out.println("==========在小餐馆吃=========");
        eatOne.eatSomething();

        // 在大饭店吃
        System.out.println("==========在大饭店吃=========");
        eatTwo.eatSomething();
    }

}
