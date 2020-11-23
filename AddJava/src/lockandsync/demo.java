package lockandsync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import thread.P;

/**
 * 公平锁：是指多个线程按照申请锁的顺序来获取锁
 * 非公平锁：是指多个线程获取锁的顺序，并不是按照申请锁顺序，有可能后申请的线程比先申请的线程优先获得锁，在高并发的情况下，有可能会造成优先级反转或者饥饿现象
 * 可重入锁（递归锁	）：同一线程外层函数获取锁之后，内层递归函数仍然能获取该锁的代码，在同一个线程在外层方法获取锁的时候内层方法会自动获取锁
 * 也就是说：线程可以进入任何一个它已经拥有的锁所同步的代码块。
 * */
class Phone implements Runnable{
	public synchronized void sendSMS() {
		System.out.println(Thread.currentThread().getName()+"\t invokeSMS()");
		sendEmail();
	}
	public synchronized void sendEmail() {
		System.out.println(Thread.currentThread().getName()+"\t ########invoke sendEmail");
	}
	Lock lock=new ReentrantLock();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone phone = new Phone();
		new Thread(()->{
			phone.sendSMS();
		},"t1").start();
		new Thread(()->{
			phone.sendSMS();
		},"t2").start();
	}

}
