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
				q.name="张三";
				q.sex="男";
			}else {
				q.name="李四";
				q.sex="女";
			}
			i=(i+1)%2;
		}
		
	}

}
