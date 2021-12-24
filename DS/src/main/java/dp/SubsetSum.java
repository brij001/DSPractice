package dp;

public class SubsetSum {

    // Returns true if there is a subset of set[] with sum equal to given sum
    static boolean isSubsetSum(int[] arr, int n, int sum) {
        boolean[][] subset = new boolean[n + 1][sum + 1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0)
                    subset[i][j] = false;
                if(j==0)
                    subset[i][j] = true;
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++) {
                if(arr[i-1]>j){
                    subset[i][j] = subset[i-1][j];
                } else {
                    subset[i][j] = subset[i-1][j] || subset[i-1][j-arr[i-1]] ;
                }
            }
        }


        return subset[n][sum];
    }

    /* Driver code*/
    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }
}

/* This code is contributed by Rajat Mishra */
