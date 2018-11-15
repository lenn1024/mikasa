package ai.code.mikasa.leetcode;

import java.util.LinkedHashMap;

public class S146 {

    public static void main(String[] args){
        LRUCache lru = new LRUCache(2);
        int a = lru.get(1);
    }

    static class LRUCache{
        private int capacity;
        private LRUInstance<Integer, Integer> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new LRUInstance<>(capacity, 0.75f, true);
        }

        public int get(int key) {
            Integer value = cache.get(key);
            if(value == null){
                return -1;
            }
            return value;
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }

        class LRUInstance<K, V> extends LinkedHashMap<K, V>{

            /**
             * constructor
             * @param initialCapacity
             * @param loadFactor
             * @param accessOrder
             */
            public LRUInstance(int initialCapacity, float loadFactor, boolean accessOrder) {
                super(initialCapacity, loadFactor, accessOrder);
            }

            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest){
                if(size() > capacity){
                    return true;
                }
                return false;
            }
        }
    }
}
