package recur;

import java.util.Arrays;
import java.util.stream.Stream;

public class FloodFillDFS {


    public static void main(String args[]){
        int [][]image = {
                {0,0,0},
                {1,0,0}

        };

        FloodFillDFS floodFillDFS = new FloodFillDFS();
        floodFillDFS.floodFill(image,1,1,2);

        System.out.println(Arrays.deepToString(image));


    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return floodFillHelper(image, sr, sc, newColor, image[sr][sc]);
    }


    public int[][] floodFillHelper(int[][] image, int sr, int sc, int newColor, int srtColor) {
        if(sr<0 || sr> image.length-1 || sc<0 || sc> image[0].length-1 || image[sr][sc] == newColor || image[sr][sc] != srtColor ) {
            return image;
        }

        image[sr][sc] = newColor;

        image = floodFillHelper(image, sr+1, sc, newColor, srtColor);
        image = floodFillHelper(image, sr-1, sc, newColor, srtColor);
        image = floodFillHelper(image, sr, sc+1, newColor, srtColor);
        image = floodFillHelper(image, sr, sc-1, newColor, srtColor);

        return image;

    }


}
