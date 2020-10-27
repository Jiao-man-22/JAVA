package Test;
/*
 * static修饰方法是  只能访问到类中的stati修饰的成员变量*/
public class Test_1 {
	static int i=5;
	static int j=10;
	public static void main(String[] args) {
	//	int i=10;
	//	int j=10;
		System.out.print(i+j);
	}
	
}
