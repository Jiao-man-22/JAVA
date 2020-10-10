package Test;

public class Dog implements TestInterface {

	@Override
	public  void eat() {
		// TODO Auto-generated method stub
		System.out.print("狗吃肉了======");
		
	}

	@Override
	public void drink() {
		// TODO Auto-generated method stub
		System.out.print("狗喝水了======");
	}
	public static void sleep() {
		System.out.print("狗子睡觉、了=====");
	}

}
