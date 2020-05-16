package jiao.exception;
/**
 * 基本类型转换
 * 
 * */

public class Demo {
	public static void main(String[] ars) {
		//大范围 转先小范围 强转
		int x=1;
		byte b=(byte)x;
		System.out.println(b);
		//小范围转大范围;直接转
		long l=b;
		System.out.println(l);
		
		
		
	
	}
}
