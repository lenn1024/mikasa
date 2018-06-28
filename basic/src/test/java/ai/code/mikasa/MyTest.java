package ai.code.mikasa;

import ai.code.mikasa.annotation.Joy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

@Joy("test annotation")
public class MyTest<T> implements Serializable, Cloneable {

    private List<String> list;

    private transient int num;
    private volatile String str;

    private final String name = "ai.code.mikasa.MyTest";

    public MyTest(){
        System.out.println("11111");
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
    public void test(){
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

}
