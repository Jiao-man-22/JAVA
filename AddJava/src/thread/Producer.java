package thread;
/*
 * 线程之间通信
 * 
 * */
public class Producer implements Runnable {
	
	P q=null;
	public Producer(P q) {
		this.q=q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(true) {
			if(i==0) {
				q.set("张三", "男");
			}else {
				q.set("李四", "女");;
			}
			i=(i+1)%2;
		}
		
	}

}
