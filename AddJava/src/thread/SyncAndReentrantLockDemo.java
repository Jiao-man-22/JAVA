package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * synchronized:java 关键字 jvm层面
 * lock:api层面  手动释放
 * */
class ShareResource{
	private int number=1;
	private Lock lock=new ReentrantLock();
	private Condition c1=lock.newCondition();
	private Condition c2=lock.newCondition();
	private Condition c3=lock.newCondition();
	public void print5() {
		lock.lock();
		try {
			while(number!=1) {
				c1.await();
			}
			// 2 干活
			for( int i=0;i<=5;i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
			// 3通知
			number=2;
			c2.signal();
		}catch(Exception e) {e.printStackTrace();}finally {
		lock.unlock();
		}
	}
	public void print10() {
		lock.lock();
		try {
			while(number!=2) {
				c2.await();
			}
			// 2 干活
			for( int i=0;i<=10;i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
			// 3通知
			number=3;
			c3.signal();
		}catch(Exception e) {e.printStackTrace();}finally {
		lock.unlock();
		}
	}
	public void print15() {
		lock.lock();
		try {
			while(number!=3) {
				c3.await();
			}
			// 2 干活
			for( int i=0;i<=15;i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
			// 3通知
			number=1;
			c1.signal();
		}catch(Exception e) {e.printStackTrace();}finally {
		lock.unlock();
		}
	}
}
public class SyncAndReentrantLockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShareResource shareResource = new  ShareResource();
		new Thread(()->{
			shareResource.print5();
		},"A").start();
		new Thread(()->{
			shareResource.print10();
		},"B").start();
		new Thread(()->{
			shareResource.print15();
		},"C").start();
		
	}

}
