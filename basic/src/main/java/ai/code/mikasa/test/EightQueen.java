package ai.code.mikasa.test;

public class EightQueen {
    private int n = 8;
    private int[][] chess;

    /**
     * 初始化棋盘
     */
    public void init(){
        this.chess = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chess[i][j] = 0;
            }
        }
    }

    public void sloveQueen(){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(isValid(chess, row, col)){
                    chess[row][col] = 1;
                }
            }
        }
    }

    /**
     * 判断row和col位置
     * @param chess
     * @param row
     * @param col
     * @return
     */
    public boolean isValid(int[][] chess, int row, int col){
        int count = 1;
        while (row - count >= 0){
            // 中上
            if(chess[row - count][col] == 1){
                return false;
            }
            // 左上
            if(col - count >= 0 && chess[row - count][col - count] == 1){
                return false;
            }
            // 右上
            if(col + count < n && chess[row - count][col + count] == 1){
                return false;
            }
        }

        return true;
    }
}
