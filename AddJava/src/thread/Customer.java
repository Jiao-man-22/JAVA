package thread;

public class Customer implements Runnable{
	private Bank b=new Bank();
	//起线程之后执行该方法
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++) {
			b.add(10);
		}
		
	}
	

}
