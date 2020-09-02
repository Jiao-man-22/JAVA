package thread;
/*线程死锁
 * 一个 snychronized 修饰的方法 可以在多个线程之间进行同步
 * 当一个线程进入snychronized 修饰的方法 其他线程就不能进入这个对象 的所有synchroniezd修饰的的方法，直到synchronied修饰的方法结束
 * 
 * */
public class DeadLockDemo implements Runnable {
	
	A a = new A();
	B b = new B();

	public DeadLockDemo() {
		//设置当前 线程名称
		Thread.currentThread().setName("Main====>Thread");
		Thread thread = new Thread(this);
		thread.start();
		a.funA(b);
		System.out.println("main线程运行完毕 ");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread.currentThread().setName("Test===>Thread");;
		new Thread(this).start();
		b.funB(a);
		System.out.println("其它线程运行完毕 ");
	}

}
class A{
 synchronized void funA(B b) {
	 String name = Thread.currentThread().getName();
	 System.out.println(name+"进入 A.foo");
	 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 System.out.println(name +"调用 B类中的 last 方法 ");
	 b.last(); 
 }
 synchronized void last() {
	 System.out.println("A类中的last 方法 ");
 }
}
class B{
	synchronized void funB(A a) {
		String name = Thread.currentThread().getName();
		System.out.println(name+"进入 b.foo");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"调用A类中的last 方法 ");
		a.last();	
	}
	
	synchronized void last() {
		System.out.println("B类中的 last 方法 ");
	}
}
