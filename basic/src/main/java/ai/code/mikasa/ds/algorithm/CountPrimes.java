package ai.code.mikasa.ds.algorithm;

/**
 * leetcode 204
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int primes = 0;
        for(int i = 2; i < n; i++){
            if(isPrime(i)){
                primes++;
            }
        }
        return primes;
    }

    private boolean isPrime(int num){
        for(int i = 2; i <= num / i; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        CountPrimes instance = new CountPrimes();
        System.out.println(instance.countPrimes(10));
    }
}
