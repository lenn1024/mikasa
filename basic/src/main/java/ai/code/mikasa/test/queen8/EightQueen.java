package ai.code.mikasa.test.queen8;

public class EightQueen {
    private int n = 8;
    private int[][] chess;
    private int[] colValue = new int[n];
    int total = 0;

    public static void main(String[] args){
        EightQueen eightQueen = new EightQueen();
        eightQueen.init();

        eightQueen.solveQueen();
        System.out.println(eightQueen.total);
    }

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

    public void solveQueen(){
        // 当前行
        int currentRow = 0;
        // 当前列
        int currentCol = 0;

        while (true){
            // 退出条件
            if(currentRow == 0 && currentCol == n){
                break;
            }

            boolean success = setCurrentRow(currentRow, currentCol);
            if(success){
                // 若成功且为最后一行
                if(currentRow == n - 1){
                    total++;
                    printChess();
                    int preCol = colValue[currentRow];
                    chess[currentRow][preCol] = 0;
                    currentCol = preCol + 1;
                }else {
                    // 成功，则设置下一行
                    currentRow++;
                    currentCol = 0;
                }
            }else {
                // 若失败，则回溯
                currentRow--;
                int preCol = colValue[currentRow];
                colValue[currentRow] = 0;
                chess[currentRow][preCol] = 0;
                currentCol = preCol + 1;
            }
        }
    }

    /**
     * 设置当前列
     * @param row
     * @return
     */
    public boolean setCurrentRow(int row, int startCol){
        for(int  col= startCol; col < n; col++){
            if(isValid(chess, row, col)){
                chess[row][col] = 1;
                // 记录下列数
                colValue[row] = col;
                return true;
            }
        }
        return false;
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
            count++;
        }

        return true;
    }

    public void printChess(){
        System.out.println("================");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(chess[i][j] + ",");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
