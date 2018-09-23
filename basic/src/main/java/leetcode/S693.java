package leetcode;

/**
 * 判断一个数的二进制是否相邻两位为不同的
 */
public class S693 {
    public static void main(String[] args){
        S693 instance = new S693();
        System.out.println(instance.hasAlternatingBits(5));
        System.out.println(instance.hasAlternatingBits(7));
    }

    public boolean hasAlternatingBits(int n) {
        int mod = -1;

        // 取模不断与上一位模作比较
        while (n != 0){
            if(n % 2 == mod){
                return false;
            }
            mod = n % 2;
            n = n/2;
        }

        return true;
    }
}
