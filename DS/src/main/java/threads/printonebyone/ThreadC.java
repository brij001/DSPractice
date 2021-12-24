package threads.printonebyone;

public class ThreadC extends Thread {
	Flag f;
	static int c=3;

	public ThreadC(Flag f) {
		this.f = f;
	}

	 @Override
	 public void run(){

			synchronized (f) {
				for(int i=1;i<11;i++) {
					while(f.flag!=3){
						try {
							f.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					System.out.println("C"+c + " ");
					f.flag = 1;
					c+=3;
					f.notifyAll();
				}
			}
		}
	}
