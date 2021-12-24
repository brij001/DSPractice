package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class SecondHighestAfterGivenNumber {
	public static void main(String args[]){
		int arr[] = {5,2,1,6,3, 4, 8 , 9};

		//521 4 9863
		
		int ind =  getIndexOfNumberFirstBigger(arr);
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=ind; i<arr.length;i++ ){
			al.add(arr[i]);
		}
		
		Collections.sort(al);
		
		
		int len = 0;
		boolean done = false;
		// reversing array in sorted order
		for(int i = ind; i<arr.length;i++){
			
			arr[i] = al.get(al.size()-1-len++);
			
			if(arr[ind-1]>arr[i] && !done) {
				swap(arr, ind-1, i);
				done = true;
			}
		}
		
		System.out.println(createNumber(arr));
		
	}
	
	
	static int getIndexOfNumberFirstBigger(int arr[]){
		
		for(int i=arr.length-1; i>0;  i--){
			if(arr[i-1]>arr[i]){
				return i;
			} 
		}
		return -1;
		
	}
	
	
	static void swap(int[] arr, int index1, int index2){
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	
	static int createNumber(int arr[]){
		int number  = 0;
		for(int i=0 ; i< arr.length; i++){
			number = number*10 + arr[i];
		}
		return number;
	}
}
