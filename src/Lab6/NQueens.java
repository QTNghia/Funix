package Lab6;

import org.jetbrains.annotations.NotNull;
//

public class NQueens {
    public static void main(String[] args) {
        int n = 5;
        nQueens(n);
    }

    /**
     *
     * @param noOfQueens Số lượng quân hậu muốn đặt
     */
    private static void nQueens(int noOfQueens){
        int[] board = new int[noOfQueens];
        placeQueens(board, 0, noOfQueens);
    }

    /**
     *
     * @param board
     * @param current
     * @param noOfQueens
     */
    private static void placeQueens (int[] board, int current, int noOfQueens){
        if (current == noOfQueens){
            displayQueens(board);
            return;
        }
        //Quay lui: ket hop vong lap va de quy
        //Neu de quy khong thi chi tim duoc 1 vi tri quan hau
        //Tim hieu ve flag
        for (int i = 0; i < noOfQueens; i++) {
            board[current] = i;
            if (noKill(board, current)){
                placeQueens (board, current + 1, noOfQueens);
            }
        }
    }

    /**
     * Kiểm tra vị trí đặt quân hậu có được hay không
     * @param board Mảng NxN bàn cờ
     * @param currentColumOfQueen vị trí xét duyệt của quân hậu, cột dọc
     * @return true or false
     */
    private static boolean noKill(int[] board, int currentColumOfQueen){
        for (int i = 0; i < currentColumOfQueen; i++) {
            //same row
            if (board[i] == board[currentColumOfQueen]){
                return false;
            }
            //diagonal
            if ((currentColumOfQueen - i) == Math.abs(board[currentColumOfQueen] - board[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * Hiển thị quân hậu trên bàn cờ
     * @param board
     */
    private static void displayQueens(int @NotNull [] board){
        /*for (int count: board) {
            System.out.print(count + " ");
            System.out.println();
        }*/
        //System.out.printf("\n%3d: ", ++tempValue);
        System.out.println();
        for (int j : board) {
            System.out.printf("%4d", j);
        }
    }
}
