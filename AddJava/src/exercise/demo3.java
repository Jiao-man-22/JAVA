package exercise;
/*
 * 9.28*/
public class demo3 {
	//得到学费
	public static void getFee(float fee,int year) {
		float allFee=0.0f;
		for(int i=0;i<year;i++) {
			allFee=(float) (fee+fee*0.05);
			fee= allFee;
		}
		System.out.print(allFee);
	}
	//使用while循环找N*N大于12000的最小整数
	public static void getMin() {
		int x=1;
		while(x>0) {
			x++;
			System.out.println("x="+x);
			if(x*x>12000) {
				System.out.println("x的最小整数为："+x);
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//getFee(10000,10);
			getMin();
	}

}
