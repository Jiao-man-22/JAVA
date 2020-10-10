package exercise;

import java.util.Scanner;

public class dome5 {

	public static int  getDigitOfNumber(long n) {
		int count =0;
		while(n>=1) {
			n=n/10;
			count++;
		}
		return count;
	}
	public static int sumDigits(long n) {
		int total=0;
		int count=0;
		count=getDigitOfNumber(n);
		for(int i=0;i<count;i++) {
			long v=n%10;
			total+=v;
			n/=10;
		}
		return total;
	}
	public static void main(String[] args){
		System.out.print("请输入一个整数=======");
		Scanner scanner = new Scanner(System.in);
		long n=scanner.nextLong();
		System.out.println(getDigitOfNumber(n));
		System.out.print(sumDigits(n));
	}
}
