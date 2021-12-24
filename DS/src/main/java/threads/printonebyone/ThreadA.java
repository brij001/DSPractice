package threads.printonebyone;

public class ThreadA extends Thread {
	Flag f;
	static int a=1;

	public ThreadA(Flag f) {
		this.f = f;
	}

	@Override
	public void run(){

		synchronized (f) {
			for(int i=1;i<11;i++) {
				while(f.flag!=1){
					try {
						f.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.print("A"+a+" ");
				f.flag = 2;
				a=a+3;
				f.notifyAll();
			}
		}
	}
}
