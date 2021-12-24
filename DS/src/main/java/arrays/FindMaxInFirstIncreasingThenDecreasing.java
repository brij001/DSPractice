package arrays;

// https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/?ref=rp
public class FindMaxInFirstIncreasingThenDecreasing {
    static int findMaximum(int arr[], int low, int high)
    {

	/* Base Case: Only one element is
		present in arr[low..high]*/
        if (low == high)
            return arr[low];

	/* If there are two elements and
		first is greater then the first
		element is maximum */
        if ((high == low + 1) && arr[low] >= arr[high])
            return arr[low];

	/* If there are two elements and
		second is greater then the second
		element is maximum */
        if ((high == low + 1) && arr[low] < arr[high])
            return arr[high];

        /*low + (high - low)/2;*/
        int mid = (low + high)/2;

        if ( arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
            return arr[mid];

        if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
            return findMaximum(arr, low, mid-1);
        else
            return findMaximum(arr, mid + 1, high);
    }

    // main function
    public static void main (String[] args)
    {
        int arr[] = {1, 3, 50, 10, 9, 7, 6};
        int n = arr.length;
        System.out.println("The maximum element is "+
                findMaximum(arr, 0, n-1));
    }
}



