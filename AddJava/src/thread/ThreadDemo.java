package thread;
/**
 * 线程安全就是不能让同一代码块被多个线程使用 
 * 可以借助锁
 * 同步代码块
 * 同步方法
 * */

public class ThreadDemo {

	public static void main(String[] args) {
		TestThread t = new TestThread();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}
}

class TestThread implements Runnable {
	private int ticket = 20;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			// 针对原子性代码 ，能保证同意时刻只有 一条进程能进入程序块
			synchronized (this) {
				if (ticket > 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "出售票为" + ticket--);
				}
			}
		}
	}

}
