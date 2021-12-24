package arrays.matrix;

// Java implementation of the approach
import java.util.Arrays;
public class CountTotalPathMatrix {


    // Recursive function to return the total
    // paths from grid[i][j] to grid[n - 1][n - 1]
    static int totalPaths(int i, int j, int n, int grid[][], int dp[][])
    {

        // Out of bounds
        if (i < 0 || j < 0 || i >= n || j >= n)
            return 0;

        // If the current state hasn't been solved before
        if (dp[i][j] == -1) {
            System.out.println("Start : " + dp[i][j]);
            // Only valid move is right
            if (grid[i][j] == 1)
                dp[i][j] = totalPaths(i, j + 1, n, grid, dp);

                // Only valid move is down
            else if (grid[i][j] == 2)
                dp[i][j] = totalPaths(i + 1, j, n, grid, dp);

                // Right and down, both are valid moves
            else
                dp[i][j] = totalPaths(i, j + 1, n, grid, dp)
                        + totalPaths(i + 1, j, n, grid, dp);
        }
        System.out.println("Last : " + dp[i][j]);
        return dp[i][j];
    }

    // Recursive function to return the maximum
    // sum along the path from grid[i][j] to grid[n - 1][n - 1]
    static int maxSumPath(int i, int j, int n, int grid[][], int dp[][])
    {

        // Out of bounds
        if (i < 0 || j < 0 || i >= n || j >= n)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];
        // If the current state hasn't been solved before
        else  {

            // Only valid move is right
            if (grid[i][j] == 1)
                dp[i][j] = grid[i][j] + maxSumPath(i, j + 1, n, grid, dp);

                // Only valid move is down
            else if (grid[i][j] == 2)
                dp[i][j] = grid[i][j] + maxSumPath(i + 1, j, n, grid, dp);

                // Right and down, both are valid moves
            else
                dp[i][j] = grid[i][j]
                        + Math.max(maxSumPath(i, j + 1, n, grid, dp),
                        maxSumPath(i + 1, j, n, grid, dp));
        }
        return dp[i][j];
    }

    // Driver code
    public static void main(String[] args)
    {
        int grid[][] = { { 1, 1, 3, 2, 1 },
                { 3, 2, 2, 1, 2 },
                { 1, 3, 3, 1, 3 },
                { 1, 2, 3, 1, 2 },
                { 1, 1, 1, 3, 1 } };
        int n = grid.length;

        // Fill the dp[][] array with -1
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        // When source and destination are same
        // then there is only 1 path
        dp[n - 1][n - 1] = 1;

        // Print the count of paths from
        // grid[0][0] to grid[n - 1][n - 1]
        System.out.println("Total paths: "
                + totalPaths(0, 0, n, grid, dp));

        // Fill the dp[][] array again with -1
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        // When source and destination are same
        // then the sum is grid[n - 1][n - 1]
        dp[n - 1][n - 1] = grid[n - 1][n - 1];

        // Print the maximum sum among all the paths
        // from grid[0][0] to grid[n - 1][n - 1]
        System.out.println("Maximum sum: "
                + maxSumPath(0, 0, n, grid, dp));
    }
}
