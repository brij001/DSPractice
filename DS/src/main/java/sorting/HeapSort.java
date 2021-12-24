package sorting;

public class HeapSort {
	
	public static void main(String args[]){
		int arr[] = {10,50,90,110,4,40,70};
		
		heapsort(arr, arr.length, 0);
		
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		
		
	}
	
	
	public static void heapify(int a[], int size, int root){
		int largest = root;
		int l = 2*root + 1;
		int r = 2*root + 2;
		
		
		if(l<size && a[largest]<a[l]){
			largest = l;
		} 
		if(r<size && a[largest]<a[r]){
			largest = r;
		}
		
		if( largest!=root){
			
			int temp = a[largest];
			a[largest]=a[root];
			a[root]=temp;
			
			heapify(a, size, largest);
		}
	}
	 
	
	public static void heapsort(int a[], int size, int root){
		
		
		// To build max heap
		// It goes from making heap from leaf node to Up 
		for(int i=size/2-1; i>=0;i--){
			heapify(a, size, i);
		}
		
		for(int i=size-1;i>=0;i--){
			int temp = a[i];
			a[i]=a[0];
			a[0]=temp;
			
			heapify(a, i, 0);
		}
		
	}

	
	

	
	
}
