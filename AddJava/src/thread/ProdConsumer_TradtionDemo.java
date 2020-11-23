package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*一个初始值为0 两个线程交替操作 
 * 1 线程 操作 资源类
 * 2 判断 干活 通知
 * 3 防止虚假 唤醒
 * synchronized:java 关键字 jvm层面
 * lock
 * */
class ShareData{//资源类
	private int number=0;
	private Lock lock=new ReentrantLock();
	private Condition conditon=lock.newCondition();
	public  void increment() throws InterruptedException {
		//枷锁
		lock.lock();
		try {
			//1 判断
			while(number!=0) {
				//等待 不能生产
				conditon.await();	
			}
			//干活
			number++;
			System.out.println(Thread.currentThread().getName()+"\t"+number);
			//通知唤醒
			conditon.signalAll();
		}catch(Exception e) {
			e.printStackTrace();
		 }finally {
	
			 lock.unlock();
		}	
		
	}
	public  void decrement() throws InterruptedException {
		//枷锁
		lock.lock();
		try {
			//1 判断
			while(number==0) {
				//等待 不能减少
				conditon.await();	
			}
			//干活
			number--;
			System.out.println(Thread.currentThread().getName()+"\t"+number);
			//通知唤醒
			conditon.signalAll();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}	
		
	}
	
}

public class ProdConsumer_TradtionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShareData shareData = new ShareData();
		new Thread(()->{
			for (int i = 1; i <= 5; i++) {
				try {
					shareData.increment();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"AA").start(); 
		new Thread(()->{
			for (int i = 1; i <= 5; i++) {
				try {
					shareData.decrement();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"BB").start();
		

	}

}
