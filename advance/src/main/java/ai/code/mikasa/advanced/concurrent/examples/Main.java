package ai.code.mikasa.advanced.concurrent.examples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lenn on 17/4/26.
 */
public class Main {
    public static void main(String[] args){
        Bank bank = new Bank();

        System.out.println(bank.getTotalBalance());
    }

    public void blockQueue(){
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        for(int i=0; i < 5; i++){
            new Thread(new Producer(queue)).start();
        }

        for(int i=0; i < 2; i++){
            new Thread(new Consumer(queue)).start();
        }
    }
}
