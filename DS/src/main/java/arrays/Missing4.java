package arrays;

//Java program to find missing 4 elements 
//in an array of size N where elements are 
//in range from 1 to N+4. 
class Missing4 { 

	// Finds missing 4 numbers in O(N) time 
	// and O(1) auxiliary space. 
	public static void missing4(int[] arr) 
	{ 
		// To keep track of 4 possible numbers 
		// greater than length of input array 
		// In Java, helper is automatically 
		// initialized as 0. 
		int[] helper = new int[4]; 

		// Traverse the input array and mark 
		// visited elements either by marking 
		// them as negative in arr[] or in 
		// helper[]. 
		for (int i = 0; i < arr.length; i++) { 
			int temp = Math.abs(arr[i]); 

			// If element is smaller than or 
			// equal to length, mark its 
			// presence in arr[] 
			if (temp <= arr.length) 
				arr[temp - 1] *= (-1); 

			// Mark presence in helper[] 
			else if (temp > arr.length) { 
				if (temp % arr.length != 0) 
					helper[temp % arr.length - 1] = -1; 
				else
					helper[(temp % arr.length) + 
								arr.length - 1] = -1; 
			} 
		} 

		// Print all those elements whose presence 
		// is not marked. 
		for (int i = 0; i < arr.length; i++) 
			if (arr[i] > 0) 
				System.out.print(i + 1 + " ");	 
		for (int i = 0; i < helper.length; i++) 
			if (helper[i] >= 0) 
				System.out.print(arr.length + i + 1 + " ");			 
		
		return; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int[] arr = {4,6}; //{ 9, 12, 3, 7, 5, 10, 8, 4, 1 };
		System.out.println(arr.length);
		missing4(arr); 
	} 
} 
