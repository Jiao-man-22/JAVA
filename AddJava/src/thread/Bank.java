package thread;

public class Bank {
	private int sum;
	public void add(int num) {
		//实现同步锁
		synchronized (this) {
			sum=sum+num;
			System.out.println("账户余额为："+sum);
		}
	}
}
