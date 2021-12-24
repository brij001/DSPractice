package arrays;

import java.util.Arrays;

public class FindDuplicatesInArrayWithFreq {


    // Driver program
    public static void main(String[] args) {
        FindDuplicatesInArrayWithFreq duplicate = new FindDuplicatesInArrayWithFreq();
        int arr[] = {0, 2, 0, 1, 2, 2, 6, 6};
        int arr_size = arr.length;

        duplicate.printRepeating(arr, arr_size);
    }

    void printRepeating(int arr[], int size) {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++) {
            arr[arr[i] % size] = arr[arr[i] % size] + size; // Increase the number at i by size
        }

        for (i = 0; i < size; i++) {

            if (arr[i] / size > 1) {
                System.out.println(" " + i + " Freq - " + arr[i] / size);
            }
        }
    }


}


