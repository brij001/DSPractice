package arrays.matrix;

// https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
public class CountPathMatrix {

    public static void main(String[] args)
    {
        int matrix[][] = {{1, 2, 3, 4},
                {4, 8, 2, 6},
                {1, 5, 3 , 7},
                {8,8,9,7}
        };

        int rows = 4; //matrix.length;
        int cols = 4; //matrix[0].length;

        pathCountUsingDP(matrix);
        System.out.println(pathCount(matrix,rows-1,cols-1));
    }


    public static int pathCount(int[][] matrix, int rows, int cols){

        // If either given row number is first or
        // given column number is first
        if (rows == 0 || cols == 0)
            return 1;

        // If diagonal movements are allowed then
        // the last addition is required.
        return pathCount(matrix,rows - 1, cols) + pathCount(matrix,rows, cols - 1);
        // + numberOfPaths(m-1, n-1);
    }


    public static void pathCountUsingDP(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int DP[][] = new int[rows][cols];
        for(int i=0; i< rows; i++){
            DP[0][i]=1;
            DP[i][0]=1;
        }

        for(int i=1; i< rows; i++){
            for(int j=1; j<cols;j++){
                DP[i][j] = DP[i-1][j] + DP[i][j-1];
            }
        }
        System.out.println(DP[rows-1][cols-1]);
    }

}
