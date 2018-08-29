package ai.code.mikasa.test;

public class Main {
    public static void main(String[] args){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run and exit.");
            }
        });
        // 守护线程，如果最后只有守护线程在运行，则JVM会结束
        thread.setDaemon(true);
        thread.start();

        System.out.println("main thread run and exit.");
    }
}
