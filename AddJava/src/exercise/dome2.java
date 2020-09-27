package exercise;

import java.util.Scanner;

/*
 * 判断任意一元二次方程的跟
 * */
public class dome2 {
	public static void getWays() {
		int a=0,b=0,c=0;
		int[] pmerter= new int[3];
		String[] p= {"a","b","c"};
		for(int i=0;i<3;i++) {
			System.out.println("请输入方程参数"+p[i]);
			Scanner scanner = new Scanner(System.in);
			pmerter[i]=scanner.nextInt();
		}
		int flag=0;
		a=pmerter[0];
		b=pmerter[1];
		c=pmerter[2];
		System.out.println("a="+pmerter[0]);
		System.out.println("b="+pmerter[1]);
		System.out.println("c="+pmerter[2]);
		flag=b*b-4*a*c;
		System.out.println(flag);
		if(flag<0){
			System.out.println("方程的跟不存在");
	}else if(flag==0) {
			System.out.println("方程只有一根");
		}else if(flag>0) {
			System.out.println("方程只有两根");
		}
		System.out.println("=========程序结束==================");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getWays();
	}

}
