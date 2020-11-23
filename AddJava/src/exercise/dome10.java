package exercise;

public class dome10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("====== ||运算===两边同为假 则假 左边为true 右边短路=========");
		System.out.println("同为真" +(1==1|| 2==2)); //真
		System.out.println("假真" +(1==3|| 2==2));  //真
		System.out.println("真假" +(1==1|| 2==3));  //真
		System.out.println("假假" +(1==2|| 2==3));  //假
		System.out.println("====== &&运算====同为真为真 左边为false 右边短路========");
		System.out.println("同为真："+ (1==1 && 2==2));//真
		System.out.println("真假："+ (1==1 && 2==3)); //假
		System.out.println("假真" +(1==2 && 2==2));  //假
		System.out.println("======&===一边为假就为假===");
		System.out.println("同真："+(1==1 & 2==2));//真
		System.out.println("真假："+(1==1 & 2==3));//假
		System.out.println("假真："+(1==2 & 2==3));//假
		System.out.println("========|===只要有一边为true就为true====");
		System.out.println("同真："+(1==1 | 2==2));//真
		System.out.println("假真："+(1==2 | 2==2));//真
		System.out.println("真假："+(1==1 | 2==3));//真
		System.out.println("假假" +(1==2  | 2==3));//假
		
		
	}

}
