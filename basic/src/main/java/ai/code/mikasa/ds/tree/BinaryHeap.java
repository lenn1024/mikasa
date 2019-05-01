package ai.code.mikasa.ds.tree;

import java.util.Arrays;

/**
 * 二叉堆实现
 * 二叉堆是一棵完全二叉树
 * @param <T>
 */
public class BinaryHeap<T extends Comparable> {

    private Object[] elements;

    private int capacity;

    private int size;

    public BinaryHeap(int capacity) {
        if(capacity < 0){
            throw new IllegalArgumentException("capacity 不能为负数: " + capacity);
        }

        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    public BinaryHeap(T[] elements, int capacity) {
        if(elements == null || elements.length < 0){
            throw new IllegalArgumentException("elements 不能为空数组。");
        }

        if(capacity < elements.length){
            throw new IllegalArgumentException("capacity 不能小于数组长度。");
        }

        this.capacity = capacity;
        this.elements = new Object[capacity];
        // 将数组元素加入到堆中
        for(T element: elements){
            if(element == null){
                continue;
            }
            add(element);
        }
    }

    public void add(T element){
        if(this.size >= this.capacity){
            // 扩容二叉堆的容量
            resize();
        }
        // 插入到二叉堆的尾部，并做上浮调整
        this.elements[size++] = element;
        upAdjust();
    }

    public void remove(int index){
        if(index >= this.size || index < 0){
            throw new ArrayIndexOutOfBoundsException("不合法的index：" + index);
        }

        this.elements[index] = this.elements[size - 1];
        this.elements[--size] = null;

        // 下沉调整
        downAdjust(index);
    }

    /**
     * 扩容
     */
    private void resize(){
        // todo something

    }

    /**
     * 上浮调整
     */
    private void upAdjust(){
        int childIndex = this.size - 1;
        int parentIndex = (childIndex - 1) / 2;

        Object temp = this.elements[childIndex];
        while (childIndex > 0 && isLessThan(temp, this.elements[parentIndex])){
            this.elements[childIndex] = this.elements[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        this.elements[childIndex] = temp;
    }

    /**
     * 下沉调整
     */
    private void downAdjust(int parentIndex){
        int childIndex = parentIndex * 2 + 1;

        Object temp = this.elements[parentIndex];
        while (childIndex < this.size){
            if(childIndex + 1 < this.size
                    && isLessThan(this.elements[childIndex + 1], this.elements[childIndex])){
                childIndex++;
            }

            if(isLessThan(temp, this.elements[childIndex])){
                break;
            }

            this.elements[parentIndex] = this.elements[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        this.elements[parentIndex] = temp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"elements\":")
                .append(Arrays.toString(elements));
        sb.append(",\"capacity\":")
                .append(capacity);
        sb.append(",\"size\":")
                .append(size);

        sb.append('}');
        return sb.toString();
    }

    /**
     *
     * @param o1
     * @param o2
     * @return
     */
    private boolean isLessThan(Object o1, Object o2){
        return ((T)o1).compareTo(o2) < 0;
    }

    public static void main(String[] args){
        Integer[] array = new Integer[]{4, 5, 1, 2, 6, 3, 7, 9, 8};
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(array, 20);

        System.out.println(binaryHeap);

        binaryHeap.add(0);

        System.out.println(binaryHeap);

        binaryHeap.remove(1);

        System.out.println(binaryHeap);
    }
}
