package arrays;
import java.util.Arrays; 
import java.util.Collections; 



public class KthSmallestElement {


	
	// Java code for kth smallest element in an array 
	
	
		// Standard partition process of QuickSort. 
		// It considers the last element as pivot 
		// and moves all smaller element to left of 
		// it and greater elements to right 
		public static int partition(int [] arr, int l,
												int r) 
		{ 
			int x = arr[r], i = l; 
			for (int j = l; j <= r - 1; j++) 
			{ 
				if (arr[j] <= x) 
				{ 
					//Swapping arr[i] and arr[j] 
					int temp = arr[i]; 
					arr[i] = arr[j]; 
					arr[j] = temp; 

					i++; 
				} 
			} 
			
			//Swapping arr[i] and arr[r] 
			int temp = arr[i]; 
			arr[i] = arr[r]; 
			arr[r] = temp; 

			return i; 
		} 
		
		// This function returns k'th smallest element 
		// in arr[l..r] using QuickSort based method. 
		// ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT 
		static int kthSmallest(int arr[], int l, int r, int k)
		{
			// If k is smaller than number of elements in array
			if (k > 0 && k <= r - l + 1)
			{
				// Partition the array around a random element and
				// get position of pivot element in sorted array
				int pos = partition(arr, l, r);

				// If position is same as k
				if (pos-l == k-1)
					return arr[pos];

				// If position is more, recur for left subarray
				if (pos-l > k-1)
					return kthSmallest(arr, l, pos-1, k);

				// Else recur for right subarray
				return kthSmallest(arr, pos+1, r, k-((pos+1)-l) );
			}

			// If k is more than number of elements in array
			return Integer.MAX_VALUE;
		}

		private static void minHeapify(int a[], int root, int size){
			int smallest = root;
			int l = 2*root+1;
			int r = 2*root+2;

			if(l<size && a[l]<a[smallest]){
				smallest = l;
			}  if(r<size && a[r]<a[smallest]){
				smallest = r;
			}
			if(smallest!=root){
				int temp = a[smallest];
				a[smallest] = a[root];
				a[root] = temp;
				minHeapify(a, smallest, size);
			}
		}

		public static int kthSmallestUsingHeap(int a[], int k){

			int size = a.length;
			for(int i = size/2 -1 ;i>=0; i--){
				minHeapify(a,i,size);
			}
			int kVal = k;
			for(int i=size-1; i>=0 ;i--){
				int temp = a[i];
				a[i] = a[0];
				a[0] = temp;
				minHeapify(a,0,i);
			}

			for(int i=0; i<size;i++){
				System.out.print("  "+ a[i] + " ");
			}
			System.out.println("Done");
			return a[size-kVal];
		}

		// Driver program to test above methods 
		public static void main(String[] args) 
		{
			int arr[] = new int[]{12, 3, 5, 7, 4, 19, 26};
			// 3,4,5,7,12,19,26
			int k = 3;
			System.out.println( "K'th smallest element is " +
						kthSmallest(arr, 0, arr.length - 1, k) );

			System.out.print( "K'th smallest element is " +
					kthSmallestUsingHeap(arr, k) );
		}
	} 

	// This code is contributed by Chhavi 
