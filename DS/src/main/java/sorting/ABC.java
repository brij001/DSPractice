package sorting;

import java.util.Scanner;

public class ABC {

    public static void main(String[] args) {

        String A = "madam";
        /* Enter your code here. Print output to STDOUT. */
        char ca[] = A.toCharArray();
        int j = A.length();
        Boolean isPalin = true;
        for(int i=0; i<A.length()/2 ; i++){
            if(ca[i]!=ca[j]){
                isPalin = false;
                break;
            }j--;
        }

        if(isPalin){
            System.out.println("Yes");
        } else
            System.out.println("No");

    }
}
