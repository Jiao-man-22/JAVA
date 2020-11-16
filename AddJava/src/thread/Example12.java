package thread;

public class Example12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow1 task = new TicketWindow1();
		new Thread(task,"窗口1").start();
		new Thread(task,"窗口2").start();
		new Thread(task,"窗口3").start();
		new Thread(task,"窗口4").start();
	}

}
class TicketWindow1 implements Runnable{
	int ticket=10;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			sendTicket();
		}
		
	}
	public synchronized void sendTicket() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ticket>0) {
			System.out.println(Thread.currentThread().getName()+"====卖出的票"+ticket--);
		}else {
			System.exit(0);
		}
	}
	
}

