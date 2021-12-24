package arrays.Others2;

import java.util.Arrays;

// https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
// https://www.youtube.com/watch?v=38JLfQGVlkw
public class MinPlatformsNeeded {

    // Returns minimum number of platforms reqquired
    static int findPlatform(int arr[], int dep[], int n)
    {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            // increment count of platforms needed
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }

            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            // Update result if needed
            result = Math.max(result, plat_needed);
        }

        return result;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlatform(arr, dep, n));
    }
}
