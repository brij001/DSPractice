package arrays;


import java.util.Arrays;

public class BinarySearch {

    static int num[] = { 2, 3, 4, 10, 40 };

    public static void main(String args[]){

        System.out.println(binarySearch(40));
    }

    public static int binarySearch(int findElt){
        Arrays.sort(num);
        int start=0;
        int end = num.length-1;
        int mid = 0;
        while(start<=end){
            mid = start+(end-start)/2;

            if(findElt==num[mid])
                return mid;

            else if(findElt<num[mid])
                end = mid-1;
            else
                start = mid+1;
        }


        return -1;
    }
}
