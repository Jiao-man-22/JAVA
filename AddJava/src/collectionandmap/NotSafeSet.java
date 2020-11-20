package collectionandmap;

import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

public class NotSafeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 HashSet<String>set=(HashSet<String>) Collections.synchronizedSet(new HashSet<String>());
		for (int i = 1; i <= 30; i++) {
			new Thread(()->{
				set.add(UUID.randomUUID().toString().substring(0,8));
				System.out.println(set);
			},String.valueOf(i)).start();
		}
		new HashSet<String>().add("a");
	}

}
