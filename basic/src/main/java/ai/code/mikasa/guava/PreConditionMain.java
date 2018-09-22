package ai.code.mikasa.guava;

import com.google.common.base.Preconditions;

/**
 * guava提供的前置条件检查类
 * 该测试列举了各个方法，还有一些重载方法
 */
public class PreConditionMain {
    public static void main(String[] args){

        /**
         * 1. 检查boolean是否为true
         */
        Preconditions.checkArgument(1 == 1);

        /**
         * 2. 检查是否为null
         */
        Preconditions.checkNotNull(new Object());

        /**
         * 3. 检查某些对象的状态
         */
        Preconditions.checkState(new Object() != null);

        /**
         * 4. 检查元素的index是否合法
         * index >=0 && index < size
         */
        Preconditions.checkElementIndex(1, 10);

        /**
         * 5. 检查元素的position是否合法
         * index > 0 && index <= size
         */
        Preconditions.checkPositionIndex(10, 10);

        /**
         * 6. 检查一个范围是否合法
         * start >= 0 && start <= end && end <= size
         */
        Preconditions.checkPositionIndexes(1, 10, 10);
    }
}
