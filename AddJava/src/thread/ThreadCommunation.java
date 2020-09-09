package thread;
/**synchroized让线程同步 避免 数据读取不完整
 * 
 * */
public class ThreadCommunation {
	public static void main(String[] args) {
		P q = new P();
		//new Thread(new Consumer(q)).start();
		//new Thread(new Producer(q)).start();
	}

}
