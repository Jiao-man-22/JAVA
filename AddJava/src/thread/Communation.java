package thread;
/*
 * 打印1-100 线程1 和线程2交替打印
 * notify() wait() notifyAll() 只能在同步代码 
 * */
class Number implements Runnable{
private int number=1;
	@Override
	public void run() {
		//同步监视器
		synchronized(this) {
			while(true) {
				notify();
				if(number<=100) {
					System.out.println(Thread.currentThread().getName()+"打印了"+number);
					number++;
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					break;
				}
			}
		}

	}
	
}
public class Communation {
	public static void main(String[] args) {
		Number number=new Number();
		Thread t1=new Thread(number);
		Thread t2=new Thread(number);
		t1.setName("甲线程");
		t2.setName("乙线程");
		t1.start();
		t2.start();	
	}
	
	
	

}
