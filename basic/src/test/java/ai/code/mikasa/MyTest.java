package ai.code.mikasa;

import ai.code.mikasa.annotation.Joy;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.*;

@Joy("test annotation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyTest<T> implements Serializable, Cloneable {

    private static Logger logger = LoggerFactory.getLogger(MyTest.class);

    private List<String> list;

    private transient int num;
    private volatile String str;

    private final String name = "ai.code.mikasa.MyTest";

    public MyTest(){
        System.out.println("call constructor.");
    }

//    public ai.code.mikasa.MyTest(String name){
//        System.out.println("11111");
//    }

//    public ai.code.mikasa.MyTest(List<String> list){
//        System.out.println("22222");
//    }

    @Before
    public void beforeTest(){
        Constructor<?>[] constructors = this.getClass().getConstructors();

        list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
    }

//    public void ai.code.mikasa.MyTest(){
//        System.out.println("调用构造函数：" + ai.code.mikasa.MyTest.class);
//    }

    public void MyTest(Integer initNum){
        System.out.println("调用构造函数：" + MyTest.class);
        System.out.println("初始化Num：" + initNum);
    }

    @Test
    public void test22() {
    }

    @Test
    public void test21() throws InterruptedException {
        new Object().wait();
    }

    @Test
    public void test20(){
        TestCaseClass testCaseClass = new TestCaseClass();
        Assert.assertTrue(testCaseClass.add(1, 2) == 3);
//        Assert.assertTrue("错了，哈哈。", testCaseClass.add(1, 2) == 4);
        System.out.println("balabala.");
    }

    @Test
    @Ignore
    public void test1(){
        // ConcurrentModificationException
        for(String str: list){
            System.out.println(str);
            list.add("d");
        }

        System.out.println("test 111");
    }

    @Test
    public void test2(){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
            if(i == 0){
                list.add("d");
            }
        }
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Long> future = executorService.<Long>submit(() -> {
            System.out.println("111111111111111");
            return Long.valueOf(6666);
        });

        System.out.println(future.isDone());
        System.out.println(future.get());
        future.get(1, TimeUnit.DAYS);

        System.out.println("2222222222222");
    }

    @Test
    public void test4() throws ExecutionException, InterruptedException {
        CompletableFuture<Long> futurePrice = new CompletableFuture<>();
        boolean result = futurePrice.complete(12L);
        System.out.println(result);
        System.out.println(futurePrice.get());
    }


    @Test
    public void test5() throws ExecutionException, InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void test6(){
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = i;
        }

        int[] copy = new int[10];

        System.arraycopy(arr, 0, copy, 0, 9);
        Arrays.stream(copy)
                .forEach(i -> System.out.println(i));
    }

    @Test
    public void test7(){
        System.out.println(Integer.class);
        // 若为数组，返回数组的类型。否则返回null
        System.out.println(Integer[].class.getComponentType());
    }

    @Test
    public void test8(){
        Class<?> clazz = this.getClass().getSuperclass();
        System.out.println(clazz.getName());
    }

    @Test
    public void test9(){
        Joy joy = MyTest.class.getAnnotation(Joy.class);
        System.out.println(joy.value());
    }

    @Test
    public void test10(){
        String a = "abcd";
        String b = "abcd";

        System.out.println(a == b);
    }

    @Test
    public void test11(){
        Annotation[] annotations = MyTest.class.getAnnotations();
        for(Annotation annotation: annotations){
            if(annotation.annotationType() == Joy.class){
                System.out.println("annotation test.");
            }
        }
    }

    @Test
    public void test12(){
        System.getProperties().list(System.out);
    }

    interface TestClass{
    }

    class AbstractTestClass implements TestClass {}

    class TestClassImpl extends AbstractTestClass implements TestClass{}

    @Test
    public void test13(){
        List<String> list = Arrays.asList("apple", "pear", "banana");
        for(Class clazz: TestClassImpl.class.getInterfaces()){
            System.out.println(clazz);
        }
    }

    @Test
    public void test14(){
        List<String> list = new ArrayList<>();
        System.out.println(list.size());
        ((ArrayList<String>) list).ensureCapacity(7);
        System.out.println(list.size());
    }

    @Test
    public void test15(){
        List<String> list = new ArrayList<String>(){{
            add("test");
        }};
        System.out.println(list.getClass());
    }

    @Test
    public void test16() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(() -> {
            try {
                Thread.currentThread().setName("t1-one");
                logger.info("sleep 1s.");
                Thread.sleep(10000);
                logger.info("sleep end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.awaitTermination(3, TimeUnit.SECONDS);
        logger.info("execute end.");
    }

    @Test
    public void test17(){
        Map<String, String> map = new LinkedHashMap<>(16, .75F, true);

        map.put("test1", "val");
        map.put("test2", "val");
        map.put("test3", "val");
        map.put("test4", "val");

        map.get("test1");

        for(Map.Entry<String, String> entry: map.entrySet()){
            System.out.println(entry.getKey());
        }
    }


    @Test
    public void test18(){
        System.out.println(tableSizeFor(9));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 2 << 30) ? 2 << 30 : n + 1;
    }

    @Test
    public void test19(){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
    }
}
