package recur;

import java.util.Arrays;

public class RatnMaze {


    public static void main(String args[]) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 1, 1}

        };

        RatnMaze ratnMaze = new RatnMaze();
        int visited[][]= new int[matrix.length][matrix[0].length];
        ratnMaze.ratnMazeHelper(matrix, visited, 0,0);
    }


    public void ratnMazeHelper(int matrix[][], int visited[][], int x, int y ){



        if(x<0 || x>matrix.length-1 || y<0 || y>matrix[0].length-1 || matrix[x][y] ==0 ||  visited[x][y]==1){
            return;
        }

        if(x==matrix.length -1 && y==matrix[0].length-1 &&  matrix[x][y] ==1 ){
            visited[x][y] = 1;
            System.out.println(Arrays.deepToString(visited));
            visited[x][y] = 0; // important step to find all the paths otherwise it will just find the first path as last node will remain visited
            return;
        }

        visited[x][y] = 1;

        ratnMazeHelper(matrix,visited,x+1, y);
        ratnMazeHelper(matrix,visited,x-1, y);
        ratnMazeHelper(matrix,visited,x, y-1);
        ratnMazeHelper(matrix,visited,x, y+1);

        visited[x][y] = 0;
    }





}
