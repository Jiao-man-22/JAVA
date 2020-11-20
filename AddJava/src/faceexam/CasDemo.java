package faceexam;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * cas是什么
 *比较并交换
 * */
public class CasDemo {

	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(5);
		//main do  thing
		System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data:"+atomicInteger.get());
		System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current data:"+atomicInteger.get());
	
	}
	

}
