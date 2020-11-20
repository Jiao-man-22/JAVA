package thread;

public class SingletonDemo {
	//保证多线程下的语义一致性，禁止指令重排
	private static volatile SingletonDemo instance=null;
	

	private  SingletonDemo() {
		System.out.println(Thread.currentThread().getName()+"\t 我是构造方法");
		// TODO Auto-generated constructor stub
	}
	//可以加syns 代价太大
	//双端检锁机制 Double Check
	public static SingletonDemo getInstance() {
		if(instance==null) {
			//同步代码块
			synchronized (SingletonDemo.class) {
				if(instance==null) {
					instance=new SingletonDemo();
					/*
					 * 分配空间 1
					 * 初始化      2
					 * 引用指向   3
					 * 多线程下会发生指令重排 321 312             
					 * */
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		// 单线程
//		System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//		System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//		System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
		//多线程
		for(int i=1;i<=10;i++) {
			new Thread(()->{
				SingletonDemo.getInstance();
			},String.valueOf(i)).start();
		}

	}

}
