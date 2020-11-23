package lockandsync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/*
 * 指尝试 获取锁的线程不会立即阻塞，采用循环的方法去获取锁
 * */
//实现自旋锁
public class SpinLock {
	AtomicReference<Thread>atomicReference=new AtomicReference<Thread>();
	public void myLock() {
		Thread thread = Thread.currentThread();
		System.out.println(Thread.currentThread().getName()+"\t come in o(n__n)o");
		while(!atomicReference.compareAndSet(null, thread)){
			
		}
	}
		
	public void myUnlock() {
		Thread thread = Thread.currentThread();
		atomicReference.compareAndSet(thread, null);
		System.out.println(Thread.currentThread().getName()+"\t invoke myUnlock()");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpinLock spinLock = new SpinLock();
		new Thread(()->{
			spinLock.myLock();
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			spinLock.myUnlock();
		},"AA").start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(()->{
			spinLock.myLock();
			spinLock.myUnlock();
		},"BB").start();
	}

}
