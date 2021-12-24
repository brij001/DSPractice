package dp;

import java.util.Arrays;

public class EggDroppingProblem {

    static int matrix[][] = new int[3][101];

    static int eggDrop(int e, int f) {
        if (f == 1 || f == 0)
            return f;

        if (e == 1)
            return f;

        if(matrix[e][f] != -1){
            return matrix[e][f];
        }

        int k, ans= Integer.MAX_VALUE;
        int temp;
        for(k=1; k <= f; k ++ ){
            temp = 1 + Math.max(eggDrop(e-1, k-1), eggDrop(e, f-k));
            ans = Math.min(temp, ans);

        }
        return matrix[e][f]= ans;
    }

    // Driver code
    public static void main(String args[])
    {
        int n = 2, k = 100;
        for(int i=0; i<=n ; i++){
            for(int j=0; j<=k;j++){
                matrix[i][j]=-1;
            }
        }


        System.out.print("Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggDrop(n, k));
    }
}

