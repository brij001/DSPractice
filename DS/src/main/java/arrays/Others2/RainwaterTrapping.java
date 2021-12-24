package arrays.Others2;

// https://www.youtube.com/watch?v=C8UjlJZsHBw
// 42. Trapping Rain Water
public class RainwaterTrapping {

    static int maxWater(int[] arr, int n) {

        int left = 0;
        int right = n - 1;

        int l_max = 0;
        int r_max = 0;

        // To store the total amount
        // of rain water trapped
        int totalTrappedWater = 0;
        while (left <= right) {

            // We need check for minimum of left
            // and right max for each element
            if (r_max <= l_max) {
                // Add the difference between current value and right max at index r
                totalTrappedWater += Math.max(0, r_max - arr[right]);
                // Update right max
                r_max = Math.max(r_max, arr[right]);

                // Update right pointer
                right -= 1;
            } else {
                totalTrappedWater += Math.max(0, l_max - arr[left]);
                l_max = Math.max(l_max, arr[left]);
                left += 1;
            }
        }
        return totalTrappedWater;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = arr.length;
        System.out.print(maxWater(arr, n));
    }
}