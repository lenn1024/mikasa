package ai.code.mikasa.spring.aop.example5;

/**
 * Created by lenn on 16/9/10.
 */
public class Performer {
    public void perform(){
        try {
            System.out.println("performing...");
        }catch (Exception e){
            System.out.println("出现异常");
        }
    }
}
