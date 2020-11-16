package thread;

public class SaveMenoyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		Thread t1= new Thread(customer);
		Thread t2 = new Thread(customer);
				t1.start();
				t2.start();
	}

}
