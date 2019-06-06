package ai.code.mikasa.leetcode;

public class S50 {

    public static void main(String[] args){
        S50 instance = new S50();
        System.out.println(instance.myPow(100, 232323));
    }

    public double myPow(double x, int n) {
        if(n < 0){
            return 1 / pow(x, -n);
        }
        return pow(x, n);
    }

    private double pow(double x, int n){
        if(n == 0){
            return 1;
        }

        double half = pow(x, n / 2);
        if(n % 2 == 0){
            return half * half;
        }
        return x * half * half;
    }
}
