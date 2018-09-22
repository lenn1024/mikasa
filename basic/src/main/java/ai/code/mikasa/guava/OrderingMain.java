package ai.code.mikasa.guava;

import com.google.common.collect.Ordering;

import java.util.Arrays;

/**
 * guava提供的一个比较器
 */
public class OrderingMain {
    public static void main(String[] args){
        boolean isOrdered = Ordering.natural()
                .nullsFirst()
                .nullsLast()
                .isOrdered(Arrays.asList(null, 1, 2, 5));

        System.out.println(isOrdered);

        System.out.println(Integer.MAX_VALUE);
    }
}
