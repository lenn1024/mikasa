package ai.code.mikasa.advanced.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lenn on 17/4/17.
 */
public class Bank {
    private int account;
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++){
            threads[i] = new Thread() {
                @Override
                public void run() {
                    for(int i= 0; i< 100; i++){
                        //System.out.println("t1 " + i + ":");
                        //System.out.println("from [" + from + "] to [" + to + "]:" + number);
                        bank.account ++;
                    }
                }
            };
        }

        for(Thread thread: threads){
            thread.start();
            thread.join();
        }

        System.out.println(bank.getTotal());
    }

    /**
     * constructor
     */
    public Bank() {
        account = 1000;
    }

    public void store(int number){
        account += number;
    }

    public void take(int number){
        account -= number;
    }


    /**
     * 显示银行总存款
     * @return
     */
    public int getTotal(){
        return account;
    }

    public static int getRandom(int num){
        return (int)(Math.random() * num);
    }
}
