package arrays;

public class SecLargest {
	public static void main(String...s){
		int aa[]={88,68,35,57,5,67,3,34,67,87,51};
		
		int largest = aa[0];
		int secondLar;
		
		if(aa[0]>aa[1]){
			largest = aa[0];
			secondLar=aa[1];
		} else{
			largest = aa[0];
			secondLar=aa[1];
		}
		
		for(int i=2; i<aa.length;i++){
			if(aa[i]>largest){
				secondLar = largest;
				largest = aa[i];
			} else if(aa[i]>secondLar)
				secondLar=aa[i];
		}
		
	secLargest(aa);



	}

	public static int secLargest(int num[]){
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		for(int i=0; i<num.length;i++){
			if(largest<num[i]){
				secondLargest = largest;
				largest=num[i];
			} else if(largest!=num[i] && secondLargest<num[i])
				secondLargest = num[i];

		}
		System.out.println("Largesst: "+largest);
		System.out.println("SECOND Largesst: "+secondLargest);
		return secondLargest;

	}
}
