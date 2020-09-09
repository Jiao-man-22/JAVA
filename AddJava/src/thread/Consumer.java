package thread;

public class Consumer implements Runnable {
	P q=null;
	
	public Consumer(P q) {
		this.q=q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
		q.get();			}
	}

}
