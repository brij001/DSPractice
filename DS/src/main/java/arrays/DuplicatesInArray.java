package arrays;

import java.util.Arrays;

public class DuplicatesInArray {
    public static void main(String ...s){
        int num[] = {3,5,6,1,2,4,2,5,6};
        removeDuplicates(num);



    }

     public static void printDuplicates(int[] num){
        int size = num.length;

        for(int i=0 ; i<size; i++){
            if(num[Math.abs(num[i])-1]<0)
                System.out.println(num[i]+", ");
            else {
                num[Math.abs(num[i])-1]=-1 *num[Math.abs(num[i])-1];
            }
        }
     }


    public static void removeDuplicates(int[] num){
        Arrays.sort(num);
//1,1,1,1
        int[] temp = new int[num.length];
        int k=0;
        for(int i=0 ; i<num.length-1; i++){
           if(num[i]!=num[i+1]){
            temp[k]=num[i]; k++;
           }
        }
        temp[k]=num[num.length-1];

        for(;k>=0;k--){
            System.out.print(temp[k]+", ");
        }
    }



}
