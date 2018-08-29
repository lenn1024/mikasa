package ai.code.mikasa.guava;

import com.google.common.base.Objects;

/**
 * guava提供的Object工具类，equal方法很有用
 */
public class ObjectMain {
    public static void main(String[] args){
        /**
         * 1. 调用正常的Object的equal方法需要判空，该方法不需要
         */
        boolean var = Objects.equal(null, null);

        /**
         * 2. hashCode方法
         */
        Objects.hashCode(new Object());
    }
}
