package ai.code.mikasa.leetcode;

public class S48 {
    public static void main(String[] args){
        S48 instance = new S48();
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        instance.rotate(matrix);
        System.out.println(matrix);
    }

    public void rotate(int[][] matrix) {
        rotate(matrix, 0, matrix.length - 1);
    }

    public void rotate(int[][] matrix, int startIndex, int endIndex){
        if(startIndex >= endIndex){
            return;
        }

        for(int i = startIndex, j = 0; i < endIndex; i++, j++){
            int temp = matrix[startIndex][i];
            matrix[startIndex][i] = matrix[endIndex - j][startIndex];
            matrix[endIndex - j][startIndex] = matrix[endIndex][endIndex - j];
            matrix[endIndex][endIndex - j] = matrix[i][endIndex];
            matrix[i][endIndex] = temp;
        }

        rotate(matrix, startIndex + 1, endIndex - 1);
    }
}
