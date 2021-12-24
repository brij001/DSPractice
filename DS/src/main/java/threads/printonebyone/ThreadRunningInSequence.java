package threads.printonebyone;

public class ThreadRunningInSequence {

	public static void main(String args[]){
		
		Flag f = new Flag();
		
		ThreadA t1 = new ThreadA(f);
		ThreadB t2 = new ThreadB(f);
		ThreadC t3 = new ThreadC(f);

		t2.start();
		t3.start();
		t1.start();
	}
}
