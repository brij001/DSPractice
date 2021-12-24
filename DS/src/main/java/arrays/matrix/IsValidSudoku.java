package arrays.matrix;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {


    public static void main(String ...ss){
        IsValidSudoku s = new IsValidSudoku();
        char[][] board2 = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        System.out.println(s.isValidSudoku(board2));
        s.solve(board,0,0);
        //

    }

    private void display(int[][] board){
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
    private void solve(int[][] board, int i, int j){
        if(i==board.length) {
            display(board);
            return;
        }
        int ni = 0;
        int nj = 0;
        if(j==board[0].length-1){
            ni = i+1;
            nj = 0;
        } else{
            ni = i;
            nj = j+1;
        }


        if(board[i][j]!=0){
            solve(board, ni, nj);
        }
        else {
            for(int val = 1; val<=9; val++){
                if(isValid(i,j,val,board)){
                    board[i][j] = val;
                    solve(board, ni,nj);
                    board[i][j] = 0;
                }
            }
        }

    }


    private boolean isValid(int row, int col, int val, int board[][]){
        if(col==5){
            System.out.println();
        }
        for(int j=0; j<board[0].length; j++){ // checking rowise
            if(board[row][j]== val)
                return false;
        }
        for(int i=0; i<board.length; i++){ // checking column wise
            if(board[i][col]==val)
                return false;
        }

        int si = row/3 * 3;
        int sj = col/3 * 3;

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3 ; j++){
                if(board[i+si][j+sj]==val)
                    return false;
            }
        }
        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        if(board==null)
            return false;

        Set<String> rowColBoxSet = new HashSet<>();
        String row = null;
        String col = null;
        String box = null;
        String boxFirstNum = "";
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(!Character.isDigit(board[i][j]))
                    continue;
                row = "Row" + i + "-"+board[i][j];
                col = "Col" + j + "-"+board[i][j];
                boxFirstNum = i/3 * 3 + "-" + j/3 * 3;
                box = "Box"+boxFirstNum + "-"+board[i][j];
                if(rowColBoxSet.contains(row)||rowColBoxSet.contains(col) || rowColBoxSet.contains(box)){
                    return false;
                } else{
                    rowColBoxSet.add(row);
                    rowColBoxSet.add(col);
                    rowColBoxSet.add(box);
                }
            }
        }
        return true;

    }


}
