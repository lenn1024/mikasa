package ai.code.mikasa.advanced.concurrent.examples;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lenn on 17/4/26.
 */
public class Bank {
    private double[] accounts;
    private Lock lock = new ReentrantLock();
    private Condition sufficientBalanceCondition = lock.newCondition();

    public Bank() {
        accounts = new double[10];
        for(int i = 0; i < 10; i++){
            accounts[i] = 1000.0;
        }
    }

    /**
     * 转账
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(int from, int to, double amount){
        lock.lock();
        try {
            while (accounts[from] < amount){
                sufficientBalanceCondition.await();
            }
            accounts[from] -= amount;
            accounts[to] += amount;
            sufficientBalanceCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public double getTotalBalance(){
        return Arrays.stream(accounts).reduce(0, (sum, item) -> sum += item);
    }
}
