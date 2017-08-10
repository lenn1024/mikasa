package ai.code.mikasa.collection;

/**
 * Created by lenn on 16/9/18.
 */

import ai.code.mikasa.annotation.Joy;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 1. HashMap和Hashtable的区别
 *   1> HashMap可以接受null键和null值, Hashtable不能
 *   2> HashMap是非线程安全的, Hashtable是线程安全的
 *
 * 2. 如果HashMap的大小超过了负载因子(load factor)定义的容量(默认值为0.75), 即
 * 当一个map填满了75%的bucket时, 和其他集合类(如ArrayList)一样,将会创建原来HashMap大小的两倍的bucket数组,
 * 来重新调整map的大小,并将原来的对象放入新的bucket数组中.这个过程叫作rehashing,因为它调用hash方法找到新的bucket位置.
 */
@Joy("joy")
public class MyMap {
    public static void main(String[] args){

        HashMap<String, String> hashMap = new HashMap<>();
        Hashtable<String, String> hashtable = new Hashtable<>();
        // 1. Hashtable不可放null值
        hashMap.put(null, null);
        // throw NullPointerException
        // hashtable.put(null, "something");
        // throw NullPointerException
        // hashtable.put("something", null);

        // 当改变一个键后
        HashMap<MyKey, String> hashMap1 = new HashMap<>();
        MyKey myKey = new MyKey("hello", "hello".length());
        hashMap1.put(myKey, "haha");

        myKey.setName("biabia");
        // 返回null,当键变了之后,已经获取不到了
        System.out.println(hashMap1.get(myKey));

        for(Map.Entry<MyKey, String> entry : hashMap1.entrySet()){
            // 输出 biabia
            System.out.print(entry.getKey().getName());
        }
    }

    static class MyKey{
        private String name;
        private int size;

        public MyKey(String name, int size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyKey myKey = (MyKey) o;

            if (size != myKey.size) return false;
            return !(name != null ? !name.equals(myKey.name) : myKey.name != null);

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + size;
            return result;
        }
    }
}
