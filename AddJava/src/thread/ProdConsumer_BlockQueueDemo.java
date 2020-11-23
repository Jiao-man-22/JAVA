package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
	private volatile boolean FLAG=true;
	private AtomicInteger atomicInteger=new AtomicInteger();
	BlockingQueue<String> blockingQueue=null;
	public MyResource(BlockingQueue<String> blockingQueue) {
		this.blockingQueue=blockingQueue;
		System.out.println(blockingQueue.getClass().getName());
	}
	public void MyProd() throws InterruptedException {
		String data=null;
		boolean reValue;
		while(FLAG) {
			data=atomicInteger.incrementAndGet()+"";
			reValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
			if(reValue) {
				System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
			}else {
				System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
			}
		TimeUnit.SECONDS.sleep(1);
		}
		System.out.println(Thread.currentThread().getName()+"\t 大老板叫停了，FLAG=false 生产动作结束");
	}
	
	public void myConsumer() throws InterruptedException {
		String result=null;
		while(FLAG) {
			result=blockingQueue.poll(2L,TimeUnit.SECONDS);
			
			if(null==result ||result.equalsIgnoreCase("")) {
				FLAG=false;
				System.out.println(Thread.currentThread().getName()+"\t 超过两秒没有取到线程，消费退出");
				System.out.println();
				System.out.println();
				return;
			}
			System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");
		}
		
	}
	public void stop() {
		this.FLAG=false;
	}
	
	
}
public class ProdConsumer_BlockQueueDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
			try {
				myResource.MyProd();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"Prod").start();
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
			try {
				myResource.myConsumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"Consumer").start();
		TimeUnit.SECONDS.sleep(5);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("5秒之后 大老板叫停，活动结束");
		myResource.stop();
	}

}
