package arrays;

public class BinarySearchInCircularSortedArray {

    public static void main(String[] args)
    {
        int[] A = {9, 10, 11,12, 1, 2, 5, 6, 8};
        int key = 5;

        int index = circularArraySearch(A, key);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }

    public static int circularArraySearch(int[] A, int x)    {
        // search space is A[left..right]
        int left = 0;
        int right = A.length - 1;

        // iterate till search space contains at-least one element
        while (left <= right)        {

            int mid = (left + right) / 2;

            // if key is found, return its index
            if (x == A[mid]) {
                return mid;
            }

            // if right half (A[mid..right]) is sorted and mid is not the key element
            if (A[mid] <= A[right])  {
                // compare key with A[mid] and A[right] to know if it lies in A[mid..right] or not
                if (x > A[mid] && x <= A[right])
                {
                    // go searching in right sorted half
                    left = mid + 1;
                }
                else {
                    right = mid - 1;    // go searching left
                }
            }

            // if left half (A[left..mid]) is sorted and mid is not the key element
            else {
                if (x >= A[left] && x < A[mid])  {
                    // go searching in left sorted half
                    right = mid - 1;
                }
                else {
                    left = mid + 1;    // go searching right
                }
            }
        }

        // key not found or invalid input
        return -1;
    }


}






