package collectionandmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerNotSafeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<String> list=new ArrayList<String>();
		//List<String> list=new Vector<String>();
	
		//List<String>  list=Collections.synchronizedList(new ArrayList<>());
		List list=new CopyOnWriteArrayList();		
		for (int i = 1; i <= 30; i++) {
			new Thread(()->{
				list.add(UUID.randomUUID().toString().substring(0,8));
				System.out.println(list);
			},String.valueOf(i)).start();
		}
		//java.util.ConcurrentModificationException 高并发多线程
		/*
		 * 故障现象
		 * java.util.ConcurrentModificationException
		 * 导致原因
		 * 并发争抢修改导致
		 * 解决方案
		 * 1 new Vector<String>();
		 * 2 list=Collections.synchronizedList(new ArrayList<>());
		 * 3 CopyOnWriteArrayList();写时复制
		 * 优化建议
		 * */
	}

}
