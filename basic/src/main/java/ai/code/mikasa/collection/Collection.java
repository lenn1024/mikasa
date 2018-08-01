package ai.code.mikasa.collection;

public interface Collection<E> extends Iterable<E> {
    /**
     * 返回集合的大小
     * @return
     */
    int size();

    /**
     * 添加一个元素
     * @param element
     * @return
     */
    boolean add(E element);


}
