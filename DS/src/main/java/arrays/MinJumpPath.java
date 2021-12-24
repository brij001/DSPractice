package arrays;

// https://www.youtube.com/watch?v=a9r98S-pDvk

public class MinJumpPath {

// JAVA Code for Minimum number
// of jumps to reach end



    public int jumpInONTime(int[] A) {
        int jumps = 0;

        int maxReach = 0;
        int currentReach = 0;
        for(int i=0; i<A.length-1; i++){
            maxReach = Math.max(maxReach, i+A[i]);
            if(i == currentReach){
                jumps++;
                currentReach = maxReach;
            }
        }
        return jumps;
    }



    private static int minJumps(int[] arr, int n)
    {
        // jumps[n-1] will hold the
        int jumps[] = new int[n];
        // result
        int i, j;

        // if first element is 0,
        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;
        // end cannot be reached

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j]
                        && jumps[j]
                        != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }

    // driver program to test above function
    public static void main(String[] args)
    {
        int arr[] = { 1, 3, 6, 1, 0, 9 };

        System.out.println("Minimum number of jumps to reach end is : "
                + minJumps(arr, arr.length));
    }
}

// This code is contributed by Arnav Kr. Mandal.
