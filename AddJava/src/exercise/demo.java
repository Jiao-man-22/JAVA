package exercise;

import java.util.Scanner;

/*
 * 读取从控制台输入
 * */
public class demo {
	public static void main(String[] args){
		//scanner 处理从控制台输入
		System.out.println("请您输入数字");
		
		Scanner scanner = new Scanner(System.in);
		 int x=0;
		x=Integer.parseInt(scanner.nextLine());
		switch (x) {
		case 1:
			System.out.println("你输入的为"+x);
			break;
		case 2:
			System.out.println("你输入的为"+x);
			break;
		case 3:
			System.out.println("你输入的为"+x);
			break;
		default:
			System.out.println("你输入的数大于3"+x);
			break;
		}
	}
}
