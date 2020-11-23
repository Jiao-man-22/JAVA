package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

	public static void main(String[] args) {
		// 资源复用
		Semaphore seap = new Semaphore(3);
		for (int i = 1; i <=6; i++) {
			new Thread(()->{
				try {
					//抢占资源
					seap.acquire();
					System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
					TimeUnit.SECONDS.sleep(3);
					System.out.println(Thread.currentThread().getName()+"\t 停车3秒后离开车位");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					//释放资源
					seap.release();
				}
			},String.valueOf(i)).start();
		}

	}

}
