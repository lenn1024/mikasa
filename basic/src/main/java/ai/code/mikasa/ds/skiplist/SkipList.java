package ai.code.mikasa.ds.skiplist;

/**
 * 跳跃表
 * @param <T>
 */
public class SkipList<T extends Comparable> {
    /**
     * 跳跃表首尾指针
     */
    private SkipListNode<T> head, tail;

    private int totalLevel;

    class SkipListNode<T>{
        /**
         * node值
         */
        private T val;

        /**
         * node指针
         */
        private SkipListNode<T> next;

        private SkipListNode[] levels;
    }
}
