package ai.code.mikasa.ds.algorithm.dp;

public class Ngrid {
    public static void main(String[] args){
        System.out.println(nGrid(10));
    }

    public static int nGrid(int n){
        if(n == 1 || n == 2){
            return n;
        }
        return nGrid(n - 1) + nGrid(n - 2);
    }
}
