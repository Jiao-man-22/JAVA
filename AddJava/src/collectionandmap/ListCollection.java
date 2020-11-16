package collectionandmap;

import java.util.Iterator;
import java.util.LinkedList;

public class ListCollection {
	
	public static void main(String[] args) {
		LinkedList link=new LinkedList();
		link.add(1);
		link.add(2);
		link.add(3);
		link.add(4);
		System.out.println(link.toString());
		link.add(5);
		link.addFirst("0");
		System.out.println(link.toString());
		link.remove(0);
		System.out.println(link.toString());
		System.out.println("使用iterator迭代器遍历");
		Iterator iterator = link.iterator();
		while(iterator.hasNext()) {
			Object next = iterator.next();
			System.out.println(next);
			
		}
	}

}
