package ds;

/**
 * Created by lenn on 17/2/9.
 */
public class MyHeap<E> {
    public static final int DEFAULT_CAPACITY = 11;

    private Object[] array;

    private int size = 0;

    public MyHeap(){
        array = new Object[DEFAULT_CAPACITY];
    }

    public MyHeap(int capacity){
        if(capacity < 1){
            throw new IllegalArgumentException("illegal capacity:" + capacity);
        }

        array = new Object[capacity];
    }

    public void add(E e){
        int i = size;

        if(i == 0){
            array[i] = e;
        }else{
            siftUp(i, e);
        }

        size++;
    }

    public void siftUp(int k, E e){
        Comparable<? super E> key = (Comparable<? super E>) e;

        while (k > 0){
            int parent = (k -1) >>> 1;

            E n = (E) array[parent];
            if(key.compareTo(n) >= 0){
                break;
            }

            array[k] = n;
            k = parent;
        }

        array[k] = key;
    }

    public void siftDown(int k, E x){
        Comparable<? super E> key = (Comparable<? super E>) x;

        int half = size >>> 1;

        while (k < half){
            int child = (k << 1) + 1;
            int right = child + 1;

            if(right < size && ((Comparable<? super E>) array[child]).compareTo((E) array[right]) > 0 ){
                child = right;
            }

            array[k] = array[child];
            k = child;
        }

        array[k] = key;
    }
}
