package arrays.matrix;

public class RotateMatrixBy90 {

    public static void main(String[] args) {
        new RotateMatrixBy90();
    }

    public RotateMatrixBy90() {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };
        rotateMatrixInplace(matrix);
        printMatrix(matrix);
    }

    public void rotateMatrixInplace(int[][] matrix) {
        int length = matrix.length-1;

        // Traverse each cycle
        for (int i = 0; i <= (length)/2; i++) {
            // In inner circle the number of elements will be decreased j will start from i say 1 and will end at N - i = 4-1 =3
            for (int j = i; j < length-i; j++) {

                //Coordinate 1
                int p1 = matrix[i][j];

                //Coordinate 2
                int p2 = matrix[j][length-i];

                //Coordinate 3
                int p3 = matrix[length-i][length-j];

                //Coordinate 4
                int p4 = matrix[length-j][i];

                //Swap values of 4 coordinates.
                matrix[j][length-i] = p1;
                matrix[length-i][length-j] = p2;
                matrix[length-j][i] = p3;
                matrix[i][j] = p4;

                // 180 Degree
                /**matrix[i][j] = p3;
                matrix[j][length-i] = p4;
                matrix[length-i][length-j] = p1;
                matrix[length-j][i] = p2; **/

                /**  90 Degree
                matrix[i][j] = p4;
                matrix[length-j][i] = p3;
                matrix[length-i][length-j] = p2;
                matrix[j][length-i] = p1;
                 **/
            }
        }
    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
