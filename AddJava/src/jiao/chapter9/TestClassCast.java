package jiao.chapter9;
class Father{
	void hit() {
		System.out.println("爸爸打儿子=====");
	}
}
class Son extends Father{
	void cry() {
		System.out.println("儿子哭了====");
	}
}

public class TestClassCast {
	/**
	 * 我的理解这可能归咎于java的单继承   子类只有一个父类 上转有目标 向下转 侧有多个子类 下转需要强制指定
	 * 
	 * 
	 * */
	
	public static void main(String[] args) {
	Son son	=(Son) new Father();//向下转型强制
	Father father=new Son();//向上转型自动
	
		
	}

}
