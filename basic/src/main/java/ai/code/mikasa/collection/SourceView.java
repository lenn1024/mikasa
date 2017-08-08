package ai.code.mikasa.collection;

import java.util.*;

/**
 * Created by lenn on 16/11/21.
 *
 */
public class SourceView {
    /**
     * 源码阅读
     * collection
     */
    private List<String> list;

    private ArrayList<String> arrayList;
    private LinkedList<String> linkedList;
    private Queue<String> queue;
    private Deque<String> deque;
    // 一种用循环数组实现的双端队列
    private ArrayDeque<String> arrayDeque;

    private Stack<String> stack;

    private Set<String> set;
    private HashSet<String> hashSet;
    private LinkedHashSet<String> linkedHashSet;
    private TreeSet<String> treeSet;
    // 一种包含枚举类型值的集
    private EnumSet enumSet;
    // 一种允许高效删除最小元素的集合
    private PriorityQueue<String> priorityQueue;

    private Map<String, String> map;
    private HashMap<String, String> hashMap;
    private LinkedHashMap<String, String> linkedHashMap;
    private TreeMap<String, String> treeMap;

    //    private EnumMap<, String> enumMap;
    // 一种用==而不是用equals比较键值的映射表
    IdentityHashMap<String, String> identityHashMap;


    public SourceView() {
    }
}
