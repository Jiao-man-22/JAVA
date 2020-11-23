package thread;

import java.util.concurrent.CyclicBarrier;

public class CyslicBarrierDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{System.out.println("******召唤神龙");});
		for (int i = 1; i <=7; i++) {
			final int tempInt=i;
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t 收集到第："+tempInt+"龙珠");
				try {
					cyclicBarrier.await();
				}catch(Exception e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
			
		}
	}

}
