package arrays.matrix;

// https://www.geeksforgeeks.org/min-cost-path-dp-6/
public class MinPathSumMatrix {

    static int row = 3;
    static int col = 3;

    public static void main(String[] args)
    {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
        System.out.print(minCostDP(cost) + "\n");
    }

    static int minCostDP(int cost[][])  {
    // for 1st column
        for (int i = 1; i < row; i++)  {
            cost[i][0] += cost[i - 1][0];
        }

    // for 1st row
        for (int j = 1; j < col; j++)  {
            cost[0][j] += cost[0][j - 1];
        }

    // for rest of the 2d matrix
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++)  {
                cost[i][j] += Math.min(cost[i - 1][j - 1], Math.min(cost[i - 1][j], cost[i][j - 1]));
            }
        }

    // Returning the value in last cell
        return cost[row - 1][col - 1];
    }



    public static int minCostRecursion(int cost[][], int m, int n)  {

        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] +
                    min( minCostRecursion(cost, m-1, n-1),
                            minCostRecursion(cost, m-1, n),
                            minCostRecursion(cost, m, n-1) );

    }

   private static int min(int x, int y, int z)   {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

}


