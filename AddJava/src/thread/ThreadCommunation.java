package thread;

public class ThreadCommunation {
	public static void main(String[] args) {
		P q = new P();
		new Thread(new Consumer(q)).start();
		new Thread(new Producer(q)).start();
	}

}
