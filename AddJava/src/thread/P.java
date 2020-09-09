package thread;

public class P {
	private String name="李四" ;
	private String sex="女";
	boolean bfull=false;
	public synchronized void set(String name,String sex) {
		if(bfull) {
			try {
				wait();//后来的进程要等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.name=name;
			try {
				Thread.sleep(10);//线程休眠十秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.sex=sex;
			bfull=true;
			notify();//唤醒最先到达的线程
		}
	}
	public synchronized void get() {
		if(!bfull) {
			try {
				wait();//
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(this.name+"---->"+this.sex);
		bfull=false;
		notify();
	}
	
}
