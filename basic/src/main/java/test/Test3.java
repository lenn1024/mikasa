package test;

public class Test3 {
    private Object object = new Object();

    public void test(){
        try {
            synchronized (this){
                System.out.println("run method test.");
                object.wait();
                Thread.currentThread().join();
                System.out.println("after run method.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        new Test3().test();
        Thread.currentThread().join();

    }
}
