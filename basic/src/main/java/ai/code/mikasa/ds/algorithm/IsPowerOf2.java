package ai.code.mikasa.ds.algorithm;

/**
 * 判断一个整数是否为2的幂次方
 */
public class IsPowerOf2 {

    public static void main(String[] args){
        System.out.println(isPowerOf2(66));
    }

    public static boolean isPowerOf2(int num){
        return (num & (num - 1)) == 0;
    }
}
