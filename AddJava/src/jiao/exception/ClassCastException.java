package jiao.exception;
/**
 * 类型转换
 * 类型转换有低精度向高精度转换 系统可以自动执行
 * 由高精度向低精度则要显示转换 即强制 执行 会造成精度丢失  
 * 显示转换
 * int x=(int)f;
 * 隐式转换
 * ClassCastException类型之间转换冲突
 * questions
 * 1 String 为什么 不能强制转 int 
 * 上转型 (父类引用指向子类对象)
 * 子类实例的给父类  是一个具体到抽象的过程 ，是安全的  
 * Parent parent=new Children();
 * 下转型，程序一般不会使用
 * 父类的实例的给子类对象 ,由抽象到具体存在安全问题      ClassCastExcption 必须 强转具体子类
 * Children children=(Children)new Parent();
 * */
class  Parent{
	public void draw(Parent p){
		System.out.println("Parent："+p);
	}
}

class Children extends Parent {
//	public void draw(Children c){
//		System.out.println("Chidren:"+c);
//	}
}

public class ClassCastException {
	
	//解决Object===》int 冲突异常
	public static void resolveObjectCastIntException(Object ob) {
		if(ob!=null) {
			//转化为 String 再转 int 
			String s=(String)ob;
			int i =Integer.parseInt(s);
			System.out.println(i);	
		}
	}
	
	
	public static void classCast(String s) {
		String a=s;
		Integer b=Integer.parseInt(s);
		System.out.println(b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//将非整形字符串 转化为 整形会报错 如下
		//java.lang.NumberFormatException
		//String s="123";
//		new ClassCastException().classCast(s);
		//将object转为 int 会报错 如下
		//java.lang.ClassCastException:
		//Object ob = new Object();
		//ob="123";
		//Object ob2=new Object();
		//ob2=123;
		//System.out.println(ob);
//		System.out.println(i);
		//将ob 转化为String 再转为 int
		//String str=String.valueOf(ob);
		//int i=Integer.parseInt(str);
		//System.out.println(str instanceof String);
		//System.out.println(i);
		//System.out.println(i);
		//测试 精度丢失问题 
		//低到高 ，自动执行隐式转换
		//int x=10;
		//float f=x;
		//System.out.println(f);
		//高到低 
		//float f=15.0f;
		//int x=(int)f;
		//System.out.println(x);
		//测试 Object ==》int
		//System.out.print(s instanceof String);
		//System.out.println(ob instanceof String);
		//resolveObjectCastIntException(ob);
		//if (ob2 instanceof Integer) {
		//	System.out.println(ob2);
		//}
		//Children children = new Children();
		//System.out.println(children instanceof Parent);
		//children.draw(children);
		Parent parent2 = new Parent();
		Children children=new Children();
		//下转型，直接转 会报 ClassCastException
//		Children c=(Children) new Parent();
		//测试下转型
//		if(c instanceof Children) {
//			System.out.println("c是 Children的实例" +c);
//		}
//		if(c instanceof Parent) {
//			System.out.println("c是 Parent的实例"+c);
//		}
		if(parent2 instanceof Parent) {
			System.out.println("parent2对象是Parent的实例 " +parent2);
		}
		if(parent2 instanceof Children) {
			//向下转型
			Children child=(Children)parent2;
			
			System.out.println("parent2是Children 的实例 "+child);
		}
		if (children instanceof Parent) {
			//上转型
			Parent p=children;//
			if(p instanceof Children) {
				System.out.println("对象p为Chilren的实例"+p);
			}
			if(p instanceof Parent) {
				System.out.println("对象p为 Parent的实例"+p);
			}
			System.out.println("children是Parent 的实例 "+children);
		}
		if (children instanceof Children) {
			System.out.println("children是Children 的实例 "+children);
		}
		
		
		
		
		
		
	}

}
