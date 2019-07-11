package ai.code.mikasa.collection;

import java.io.Serializable;
import java.util.*;

public class LennHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Serializable {

    private static final long serialVersionUID = 1151163857123648488L;

    private static final float DEFAULT_LOADFACTOR = 0.75f;

    private static final int DEFAULT_CAPACITY = 1 << 4;

    private static final int MAX_CAPACITY = 1 << 30;

    private int threshold;

    Node<K, V>[] table;

    private int size;

    /**
     * 负载因子
     */
    final float loadFactor;

    /**
     * constructor
     */
    public LennHashMap() {
        threshold = (int)(DEFAULT_CAPACITY * DEFAULT_LOADFACTOR);
        loadFactor = DEFAULT_LOADFACTOR;
        table = new Node[DEFAULT_CAPACITY];
    }

//    public LennHashMap(int initialCapacity, float loadFactor){
//        this.loadFactor = loadFactor;
//
//    }

    class Node<K, V> implements Map.Entry<K, V>{
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key) ^ Objects.hash(value);
        }
    }

    /**
     *
     * @param key
     * @param value
     * @return 返回旧值，或者返回null
     */
    public V put(K key, V value){
        int hash = hash(key);
        int index = (table.length - 1) & hash;
        Node<K, V> node = table[index];
        // 判断是否有当前key，有的话更新值
        while (node != null){
            if(node.hash == hash && node.key.equals(key)){
                V oldValue = node.value;
                node.setValue(value);
                return oldValue;
            }
            node = node.next;
        }

        // new node
        Node<K, V> e = table[index];
        Node<K, V> newNode = new Node<>(hash, key, value, e);
        table[index] = newNode;

        if(++size > threshold){
            resize();
        }

        return null;
    }



    /**
     * 调整hashmap的大小
     * @return
     */
    final Node<K, V>[] resize(){
        int oldCapacity = table.length;

        /**
         * 若map的容量已无法再扩大，则后续会保持不变
         * threshold 设置为Integer的最大值，即后续不会再调用resize方法
         */
        if(oldCapacity >= MAX_CAPACITY){
            threshold = Integer.MAX_VALUE;
            return table;
        }

        // 调整为原来的2倍
        int newCapacity = oldCapacity << 1;
        if(newCapacity > MAX_CAPACITY){
            newCapacity = MAX_CAPACITY;
        }
        threshold = (int)(newCapacity * loadFactor);
        Node<K, V>[] newTable = new Node[newCapacity];

        // 重hash对应元素
        for(int i = 0; i < table.length; i++){
            Node<K, V> node = table[i];
            // 将原table置空，以防内存泄漏
            table[i] = null;
            while (node != null){
                Node<K, V> next = node.next;
                // rehash
                int index = (newTable.length - 1) & node.hash;
                Node<K, V> after = newTable[index];
                newTable[index] = node;
                node.next = after;

                node = next;
            }
        }

        return newTable;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    // todo
    @Override
    public Set<Entry<K, V>> entrySet() {

        return null;
    }

    @Override
    public String toString() {
        return "LennHashMap{" +
                "threshold=" + threshold +
                ", table=" + Arrays.toString(table) +
                ", size=" + size +
                ", loadFactor=" + loadFactor +
                '}';
    }
}
