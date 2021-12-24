package sorting;

public class MergeSort {
	
	public static void main(String args[]){
		int arr[] = {10,50,90,110, 11, 7 ,1211};
		
		mergeSort(arr, 0, arr.length-1);
		
		for(int i = 0; i<arr.length;i++){
			//System.out.println(arr[i]);
		}
		
	}
	
	
	public static void merge(int a[], int l, int m, int h){
		int b[] = new int[h+1];
		int i=l;int j=m+1;
		int k=l;
		while(i<=m && j<=h ){
			if(a[i]<a[j]){
				b[k]=a[i];
				i++;k++;
			}else{
				b[k]=a[j];
				j++;k++;
			}
		}
		while(i<=m){
			b[k]=a[i];i++;k++;
		}while(j<=h){
			b[k]=a[j];j++;k++;
		}
		
		for(int t = l ; t<=h;t++)
			a[t]=b[t];
	}
	 
	
	public static void mergeSort(int a[], int l, int h){
		
		if(l<h){
			int m = (l+h)/2;
			//System.out.println("before first : l,m,h   "+ "("+l+","+m+","+h+")");
			mergeSort(a, l, m);
			//System.out.println("after first : l,m,h   "+ "("+l+","+m+","+h+")");
			mergeSort(a, m+1, h);
		//	System.out.println("Going Merge ("+ "("+l+","+m+","+h+")");
			merge(a, l, m, h);
		}
		
	}

}
