package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
	static AtomicReference<Integer> atomicReference= new AtomicReference<>(100);
	static AtomicStampedReference atomicStampedReference=new AtomicStampedReference<>(100,1);

	public static void main(String[] args) {
		System.out.println("============以下是ABA问题产生================");
		new Thread(()->{
			atomicReference.compareAndSet(100, 101);
			atomicReference.compareAndSet(101, 100);
			
		},"t1").start();
		//暂停一秒到t2线程  保证t1线程完成一次ABA操作
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(atomicReference.compareAndSet(100, 2019)+"\t"+atomicReference.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"t2").start();
		//暂停一会线程
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("====================以下是ABA问题解决===========================");
		new Thread(()->{
			int stamp = atomicStampedReference.getStamp();
			System.out.println(Thread.currentThread().getName()+"\t 第一次版本号："+stamp);
			//暂停一秒t3线程
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
			atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
			System.out.println(Thread.currentThread().getName()+"\t 第3次版本号"+stamp);
		},"t3").start();
		new Thread(()->{
			int stamp = atomicStampedReference.getStamp();
			System.out.println(Thread.currentThread().getName()+"\t 第一次版本号："+stamp);
			//暂停
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp+1);
			System.out.println(Thread.currentThread().getName()+"\t 修改成功否："+result+"\t 当前实际版本号："+atomicStampedReference.getStamp());
			System.out.println(Thread.currentThread().getName()+"\t 当前实际最新值："+atomicStampedReference.getReference());
		},"t4").start();
		
		
	}

}
