package jiao.chapter9;
/**
 * 多态就是在编译期的对象在运行时呈现不同的类型
 * 引用变量在编译期只能调用编译时类型所具有的方法 在运行时则执行运行时所具有的方法
 * 与方法不同的是 属性不具备多态性，系统总试图访问他编译期类型所具有的属性，而不是运行时所定义的属性
 * */
class jibaseClass{
	//属性不具备多态性
	public int book=6;
	public void base() {
		System.out.println("父类普通方法");
	}
	public void test() {
		System.out.println("父类被覆盖方法");
	}
	
}
public class duotai extends jibaseClass{
//重新定义book实例属性覆盖父类的book实例属性
	public String book="Android";
	public void test() {
		System.out.println("子类覆盖父类啊方法");
	}
	public void sub() {
		System.out.println("子类中的普通方法");
	}
	public static void main(String[] args) {
		jibaseClass sanyin = new duotai();
		System.out.println(sanyin.book);
		sanyin.base();
		sanyin.test();
		//编译时类型为jibaseClass 没有sub方法
		//sanyin.sub();
		
	}
}
