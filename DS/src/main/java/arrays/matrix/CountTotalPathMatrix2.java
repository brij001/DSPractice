package arrays.matrix;

// https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze
public class CountTotalPathMatrix2 {


    public static void main(String[] args) {
        int maze[][] = {{0, 0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0, 0, 0, 0}};
        System.out.println(countPaths(maze));
        //System.out.println(countPaths2(maze));
    }

    // Returns count of possible paths in
    // a maze[R][C] from (0,0) to (R-1,C-1)
    static int countPaths(int maze[][]) {
        int R = maze.length;
        int C = maze[0].length;
        // If the initial cell is blocked, there is no way of moving anywhere
        if (maze[0][0] == -1)
            return 0;

        // Initializing the leftmost column
        for (int i = 0; i < R; i++) {
            if (maze[i][0] == 0)
                maze[i][0] = 1;
            else
                break;
        }
        // Similarly initialize the topmost row
        for (int i = 1; i < C; i++) {
            if (maze[0][i] == 0)
                maze[0][i] = 1;
            else
                break;
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {

                if (maze[i][j] == -1)
                    continue;

                // If we can reach maze[i][j] from maze[i-1][j] then increment count.
                if (maze[i - 1][j] > 0)
                    maze[i][j] = (maze[i][j] +
                            maze[i - 1][j]);

                // If we can reach maze[i][j] from maze[i][j-1] then increment count.
                if (maze[i][j - 1] > 0)
                    maze[i][j] = (maze[i][j] +
                            maze[i][j - 1]);
            }
        }

        // If the final cell is blocked, output 0, otherwise the answer
        return (maze[R - 1][C - 1] > 0) ?
                maze[R - 1][C - 1] : 0;
    }

    public static int countPaths2(int grid[][]) {
        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == -1 || grid[row - 1][col - 1] == -1) {
            return 0;
        }

        int i = 0, j = 1; // j = 1, as grid[0][0] will be inititalized by first while loop of row (i).
        while (i < row && grid[i][0] == 0) {
            grid[i][0] = 1;
            i++;
        }
        while (j < col && grid[0][j] == 0) {
            grid[0][j] = 1;
            j++;
        }

        for (i = 1; i < row; i++) {
            for (j = 1; j < col; j++) {
                if (grid[i][j] == -1) {
                    continue;
                }
                if (grid[i - 1][j] != -1)
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i - 1][j] + grid[i][j - 1]);
                else if (grid[i][j - 1] != -1) {
                    grid[i][j] = Math.max(grid[i][j - 1], grid[i][j - 1] + grid[i - 1][j]);
                }

            }

        }

        return grid[row - 1][col - 1];
    }
}
