package arrays;

import java.util.Arrays;

public class SeparatePositiveAndNegative {
	
	
	public static void main(String args[]){
		
		int a[] = {-99,1,4,-1,4,-3,-4,-9,-8,7,2};
		int p=0;
		int i=0;

		// Partition

		for(int j=0;j<a.length;j++){
			if(a[j]<p){
				swapElt(a, i, j);
				i++;
			}
		}


		System.out.println(Arrays.toString(a));
		
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
		return i;
	}
	
	
	public static void swapElt(int a[] , int i , int j){
		int temp = a[i];
		a[i] = a[j];
		a[j]=temp;
	}


	public static void partition2(int num[], int l, int h,int p){

		int i=l;


		for(int j=l;j<h;j++){

			if(num[j]<p){
				int temp = num[j];
				num[j]=num[i];
				num[i]=temp;
				i++;
			}
		}

	}


	
}
