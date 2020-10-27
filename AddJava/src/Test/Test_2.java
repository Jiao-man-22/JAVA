package Test;

public class Test_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=10;
		//
		if( i++ ==10) {
			System.out.println(i);
			System.out.println("A");
		}else if(i==11) {
			System.out.println("B");
		}else if(i++==11) {
			System.out.println("C");
		}else {
			System.out.println(i);
			System.out.println("D");
		}
	}

}
