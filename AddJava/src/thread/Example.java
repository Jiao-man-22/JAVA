package thread;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow task = new TicketWindow();
		//起线程
		new Thread(task,"窗口1").start();
		new Thread(task,"窗口2").start();
		new Thread(task,"窗口3").start();
		new Thread(task,"窗口4").start();
		
	}
}
//线程任务类
class TicketWindow implements Runnable{
	//此变量被run方法共享
	int ticket=10;
	//同步代码块的锁
	Object lock=new Object();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//我的理解： 使用同步代码块的锁，因为锁是共享又具有唯一性的，只有一个线程释放掉锁才能被另一个线程获取，达到线程同步的效果 
		synchronized (lock) {
			while(ticket>0) {
				try {
					//sleep不会让出锁
//					Thread.sleep(10);//线程休眠10
					//释放系统资源重新竞争
					Thread.yield();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"---卖出的票"+ticket--);
				
			}
			
		}

		
	}
	
}
