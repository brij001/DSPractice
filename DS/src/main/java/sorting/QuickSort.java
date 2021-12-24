package sorting;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String args[]){
		int arr[] = {10,80,75,72,20,70};
		
		quicksort(arr, 0, arr.length-1);
		
		for(int i = 0; i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
	}
	
	
	public static int partition(int a[], int l, int h){
		int i=l;
		int p= h;
		for(int j=l;j<h; j++){
			if(a[j]<=a[p]){
				int tmp = a[j];
				a[j]=a[i];
				a[i]=tmp;
				i++;
			}
		}
		int tmp = a[p];
		a[p]=a[i];
		a[i]=tmp;
		System.out.println(Arrays.toString(a));
		return i;
	}
	 
	
	public static void quicksort(int a[], int l, int h){
		
		if(l<h){
		int p = partition(a, l, h);
		
		
		quicksort(a, l, p-1);
		quicksort(a, p+1,h);
		}
		
	}

}
