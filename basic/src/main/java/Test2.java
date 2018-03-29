import org.apache.commons.lang3.math.NumberUtils;
import test.Test1;

import java.math.BigDecimal;

public class Test2 {
    public static void main(String[] args){
        Integer integer = 20;

        System.out.println(NumberUtils.toLong("20") == integer);
        System.out.println(integer == NumberUtils.toLong("20"));
        System.out.println(NumberUtils.toLong("20") == integer);
    }
}
