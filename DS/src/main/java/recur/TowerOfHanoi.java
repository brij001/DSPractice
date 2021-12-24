package recur;

public class TowerOfHanoi {

	public static void main(String args[]){
		toh(4, 'A', 'B', 'C');
	}
	
	public static void toh(int n, Character A, Character B, Character C){

		if(n<=0)
			return;

		toh(n-1, A, C,B );
		System.out.println("Transfer "+ A + " --> " + C	);
		toh(n-1, B, A, C);

	}

}
