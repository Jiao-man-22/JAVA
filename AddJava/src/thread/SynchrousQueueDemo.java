package thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchrousQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();
		new Thread(()->{
			try {
				System.out.print(Thread.currentThread().getName()+"\t put");
				synchronousQueue.put("1");
				System.out.print(Thread.currentThread().getName()+"\t put");
				synchronousQueue.put("2");
				System.out.print(Thread.currentThread().getName()+"\t put");
				synchronousQueue.put("3");
			}catch(Exception e) {
				e.printStackTrace();
			}
		},"AAA").start();
		new Thread(()->{
			try {
				
				try {
					TimeUnit.SECONDS.sleep(5);
					System.out.print(Thread.currentThread().getName()+"\t"+synchronousQueue.take());
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					TimeUnit.SECONDS.sleep(5);
					System.out.print(Thread.currentThread().getName()+"\t"+synchronousQueue.take());
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					TimeUnit.SECONDS.sleep(5);
					System.out.print(Thread.currentThread().getName()+"\t"+synchronousQueue.take());
				}catch(Exception e) {
					e.printStackTrace();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		},"BBB").start();
		
		
	}

}
