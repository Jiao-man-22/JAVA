package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * JMM规范：可见性 原子性 有序性
 * */

class MyData{
	//线程之间通信是隔离的 甲线程修改资源，乙线程无法及时得到资源变更的消息，volatile 是修饰的变量资源一被更改就被其他线程获取
	volatile int number=0;
	public void addT060(){
		this.number=60;
	}
	public  void addPlusPlus() {
		number++;
	}
	//保证原子性
	AtomicInteger atomicInteger = new AtomicInteger();
	public void AddMyAtomic() {
		atomicInteger.getAndIncrement();
	}
	
	
	
	}
/*
 * 验证volatile的可见性
 * 添加volatile 可解决可见性问题
 * 不保证原子性
 * 原子性：不可分割  完整性 即某个线程执行某个 具体业务 ，中间不可分割 同时成功或同时失败
 * 如何解决原子性
 * 加sync
 * 
 * */
public class VolatileDemo {

	public static void main(String[] args) {
		MyData myData = new MyData();//资源类
		for(int i=1;i<=20;i++) {
			new Thread(()->{
				for(int j=1;j<=1000;j++) {
					myData.addPlusPlus();
					myData.AddMyAtomic();
				}
			},String.valueOf(i)).start();;
		}
		//需要等待上面的线程执行完 main来取值
		while(Thread.activeCount()>2) {
			Thread.yield();
		}
		System.out.println(Thread.currentThread().getName()+"\t finally value"+myData.number);
		System.out.println(Thread.currentThread().getName()+"\t atom finally value"+myData.atomicInteger);
		
//		new Thread(()->{
//			System.out.println(Thread.currentThread().getName()+"\t come in");
//			//暂停线程
//			try {
//				TimeUnit.SECONDS.sleep(3);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			myData.addT060();
//			System.out.println(Thread.currentThread().getName()+"\t update number value:"+myData.number);
//		},"AAA").start();;
//		//第二个线程 main
//		while(myData.number==0) {
//			//检测不到 number的变化就会一直等下去
//		}
//		System.out.println(Thread.currentThread().getName()+"\t");
		
		}

}
