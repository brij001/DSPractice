package threads.printonebyone;

public class ThreadB extends Thread {

	Flag f;
	static int b = 2;

	public ThreadB(Flag f) {
		this.f = f;
	}

	@Override
	public void run(){

		synchronized (f) {
			for(int i=1;i<11;i++) {
				while(f.flag!=2){
					try {
						f.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.print("B"+b + " ");
				f.flag = 3;
				b+=3;
				f.notifyAll();
			}
		}
	}
}
