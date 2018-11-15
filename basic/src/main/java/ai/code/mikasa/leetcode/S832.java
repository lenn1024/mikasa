package ai.code.mikasa.leetcode;

public class S832 {
    public static void main(String[] args){
        S832 instance = new S832();
        int[][] A = instance.flipAndInvertImage(new int[][]{{1, 1, 0}});
        System.out.println(A);
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        // 遍历行
        for(int i = 0; i < rows; i++){
            int[] row = A[i];
            // 遍历列
            for(int j = 0; j < cols / 2; j++){
                int temp = row[j];
                row[j] = row[cols - j - 1] ^ 1;
                row[cols - j - 1] = temp ^ 1;
            }
            // invert the medium
            if(cols % 2 != 0){
                row[cols/2] = row[cols/2] ^ 1;
            }
        }

        return A;
    }
}
