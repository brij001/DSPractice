package arrays.matrix;

public class PrintMatrixDiagonally {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3,  4 , 5, 21, 25},
                {6,  7,  8,  9,  10, 22, 26},
                {11, 12, 13, 14, 15, 23, 27},
                {16, 17, 18, 19, 20, 24, 28},
        };

        printMatrixDiagonally1(matrix);
    }

    public static void printMatrixDiagonally(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;


        for (int i = 0; i < R; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(mat[i - j][j] + " ");
            }
            System.out.println("");
        }




        for (int k = 1; k <= C - 1; k++) {
            int col = k;
            for (int j = R - 1; j >= 0 && col <= C-1; j--) {
                System.out.print(mat[j][col] + " ");
                col++;

            }
            System.out.println("");

        }
    }

    public static void printMatrixDiagonally1(int[][] mat)
    {
        int M = mat.length;
        int N = mat[0].length;

        // print "/" diagonal for upper-left half of the matrix
        for (int r = 0; r < M; r++)
        {
            // start from each cell of first column of the matrix
            for (int i = r, j = 0; j < N && i >= 0; i--, j++) {
                System.out.print(mat[i][j] + " ");
            }

            System.out.println("");
        }


        //System.out.println("PRINTED");
        // print "/" diagonal for lower-right half of the matrix
        for (int c = 1; c < N; c++)
        {
            // start from each cell of the last row
            for (int i = M - 1, j = c; j < N && i >= 0; i--, j++) {
                System.out.print(mat[i][j] + " ");
            }

            System.out.println("");
        }
    }



}
