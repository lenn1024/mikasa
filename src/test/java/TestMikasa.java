import ai.code.mikasa.annotation.Joy;
import org.junit.Test;

import java.util.List;
import java.util.Locale;

@Joy("joy")
public class TestMikasa {
    private Long value = 0l;
    @Test
    public void test(){
        Joy joy = TestMikasa.class.getAnnotation(Joy.class);
        System.out.println(joy.value());
    }

    @Test
    public void getSimpleClassName(){
        System.out.println(TestMikasa.class.getSimpleName());
        System.out.println(TestMikasa.class.getSimpleName().toLowerCase(Locale.ENGLISH));
    }

    @Test
    public void testArray(){
        List<Integer> nums = null;
        for(Integer i : nums){
            System.out.println(i);
        }
    }

    @Test
    public void testLong(){
        System.out.println(Integer.valueOf(127) == Integer.valueOf(127));
    }


    public void setValue(Long value) {
        this.value = value;
    }
}
