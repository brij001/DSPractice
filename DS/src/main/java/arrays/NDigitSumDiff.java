package arrays;

public class NDigitSumDiff {

	public static void main(String args[]){
		int n = 7;
		SumDiff(n);
	}
	
	
	public static void SumDiff(int n){
		
		int init = (int) Math.pow(10, n-1);
		int end = (int) Math.pow(10, n)-1;
		int oddSum = 0;
		int evenSum = 0;
		
		int k = 1;
		
		for(int i=init ;i<=end; i++){
			k=1;
			oddSum = 0;
			evenSum = 0;
			char[] c = String.valueOf(i).toCharArray();
			for(int j=0;j<c.length;j=j+2, k=k+2){
				oddSum += Character.getNumericValue(c[j]);
				if(k<c.length) 
					evenSum += Character.getNumericValue(c[k]);
			}
			
			if(Math.abs(oddSum-evenSum)==1){
				System.out.println(i + " ");
			}
		}
	}
}
