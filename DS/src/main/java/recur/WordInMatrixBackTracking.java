package recur;

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=EmvsBM7o-5k
// improvement : Hashmap<Character, List<Point>>
class WordInMatrixBackTracking {

    public static void main(String args[]){
        WordInMatrixBackTracking soln = new WordInMatrixBackTracking();
        char[][] board = {
                {'A', 'B', 'C','E' },
                {'S', 'F', 'C','S' },
                {'A', 'D', 'E','E' }

        };

        System.out.println(soln.exist(board,"SEE"));
    }
    public boolean exist(char[][] board, String word) {
        WordInMatrixBackTracking soln = new WordInMatrixBackTracking();
        boolean visited[][] = new boolean[board.length][board[0].length];

        // checking from every cell whether the word starts and then next characters of the word in all horizontal and vertical directions
        for(int i=0;i<board.length; i++){
            for (int j=0;j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && soln.searchWord(board, i, j, visited, 0, word))
                    return true;
            }
        }
        return false;
    }

    public boolean searchWord(char[][] board, int i, int j, boolean[][] visited, int index, String word){

        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || visited[i][j] || index> word.length()-1 || board[i][j]!=word.charAt(index)){
            return false;
        }

        if(index==word.length()-1 && board[i][j] == word.charAt(index)){
            visited[i][j]=true;
            return true;
        }

        visited[i][j] = true;


        if(searchWord(board,i+1,j,visited,index+1, word))
            return true;
        if(searchWord(board,i-1,j,visited,index+1, word) )
            return true;
        if(searchWord(board,i,j-1,visited,index+1, word) )
            return true;
        if(searchWord(board,i,j+1,visited,index+1, word) )
            return true;
        visited[i][j] = false;

        return false;
    }
}