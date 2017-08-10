import ai.code.mikasa.annotation.Joy;
import org.junit.Test;

@Joy("joy")
public class TestMikasa {
    @Test
    public void test(){
        Joy joy = TestMikasa.class.getAnnotation(Joy.class);
        System.out.println(joy.value());
    }
}
