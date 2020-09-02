package thread;

public class ThreadDemo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread_1 t = new TestThread_1();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();

	}

}
class TestThread_1 implements Runnable{
	private int ticket=20;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
		sale();
		}
		
	}
	//synchronzied 修饰方法 为同步方法 
	public synchronized void  sale() {
		if (ticket>0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"售出票："+ticket--);
		}
	}
	
}
