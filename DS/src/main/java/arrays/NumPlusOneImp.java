package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NumPlusOneImp {


    public static void main(String...s){
        int n[] = {9,8,9};

        System.out.println(plusOne(n));

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(6);
        list.add(0);
        list.add(7);

        ArrayList<Integer> list2 = plusOne(list);
        for(Integer i : list2){
            System.out.print(i + ",");
        }
    }
    public static int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i=digits.length-1; i>=0; i-- ){
            if((digits[i]+1+carry)>=10){
                carry = (digits[i]+1)/10;
                digits[i] = (digits[i]+1)%10;
            } else{
                digits[i] = digits[i] + 1;
                carry = 0;
                break;
            }
        }

        if(carry>0){
            int newDigits[] = new int[digits.length+1];
            newDigits[0]=carry;

            for(int k=0; k<digits.length ; k++){
                newDigits[k+1] = digits[k];
            }
            return newDigits;
        }
        return digits;

    }



    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int j = 0;
        while(j<A.size() && A.get(j)==0){
            A.remove(j);

        }


        ArrayList<Integer> list = new ArrayList<Integer>();
        int carry = 0;

        int sumLastDigit = A.get(A.size()-1)+1;
        if(sumLastDigit<10){
            A.remove(A.size()-1);
            A.add(sumLastDigit);
            return A;
        } else {
            carry = sumLastDigit/10;
            A.set(A.size()-1, sumLastDigit%10 );
            for(int i=A.size()-2; i>=0; i--){
                A.set(i,A.get(i)+carry);
                carry = A.get(i)/10;
                if(A.get(i)>=10){
                    A.set(i,A.get(i)%10) ;
                }
            }
        }

        if(carry>0){
            Collections.reverse(A);
            A.add(1);
            Collections.reverse(A);
        }


        return A;
    }
}
