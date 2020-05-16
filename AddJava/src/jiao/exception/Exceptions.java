package jiao.exception;
/**
* 一、null是代表不确定的对象,但本身又不是对象,却可以用Object绑定类型  例证0-1
* 三、Java默认给变量赋值
在定义变量的时候，如果定义后没有给变量赋值，则Java在运行时会自动给变量赋值。赋值原则是整数类型int、byte、short、long的自动赋值为0，带小数点的float、double自动赋值为0.0，boolean的自动赋值为false，其他各供引用类型变量自动赋值为null。
这个具体可以通过调试来看。
四、容器类型与null
List：允许重复元素，可以加入任意多个null。
Set：不允许重复元素，最多可以加入一个null。
Map：Map的key最多可以加入一个null，value字段没有限制。
数组：基本类型数组，定义后，如果不给定初始值，则java运行时会自动给定值。引用类型数组，不给定初始值，则所有的元素值为null。
 五、null的其他作用
1、判断一个引用类型数据是否null。 用==来判断。
2、释放内存，让一个非null的引用类型变量指向null。这样这个对象就不再被任何对象应用了。等待JVM垃圾回收机制去回收。
* */

public class Exceptions {
	public static void isObject(Object x) {
		
		if(x instanceof java.lang.Object) {
			System.out.println("null 为 对象");
		}else {
			System.out.println("null 不为 对象");
		}
	}
	//main（任何）方法里面不能定义方法 可以调用方法
	public static void main(String[] args) {
		//new Exceptions().isObject(null);
		
		
		
		
	}
	
	

}
