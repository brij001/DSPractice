package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletGivenSum {

    public static void main(String...strings){

        int a[] = {12, 3, 4, 1, 6, 9};
        int sum = 24;
        //printTripletWithGivenSumWithExtraSpace(a,sum);
       // printTripletWithGivenSumSorting(a,sum);
    }

    // T O(N2); S O(n)
    public static void printTripletWithGivenSumWithExtraSpace(int a[], int sum){

        for(int i=0; i<a.length-1;i++){
            List<Integer> list = new ArrayList<Integer>();
            for(int j=i+1; j<a.length;j++){
                int rem = sum-(a[i]+a[j]);

                if(list.contains(rem)){
                    System.out.println(a[i]+ " , "+ a[j] + " , "+ rem);
                } else {
                    list.add(a[j]);
                }
            }
        }
    }

    // T O(N2); S O(1)
    public static void printTripletWithGivenSumSorting(int a[], int sum){
        Arrays.sort(a);
        for(int i=0; i<a.length-1 ; i++){
            int p2 = i+1;
            int p3 = a.length-1;
            while(p2<p3){
                if(a[p2]+a[p3]==sum - a[i]){
                    System.out.println(a[i]+ " , "+ a[p2] + " , "+ a[p3]);
                    break;
                } else if(a[p2]+ a[p3] < sum-a[i]){
                    p2= p2+1;
                } else if(a[p2]+ a[p3]>sum-a[i]){
                    p3= p3-1;
                }
            }
        }

    }



}
