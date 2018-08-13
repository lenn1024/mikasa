package ai.code.mikasa.zk;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ExclusiveLock lock = new ExclusiveLock(new ZKClient("127.0.0.1:2181", 5000), "lock");
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.unLock();
                }
            }).start();
        }
    }
}
