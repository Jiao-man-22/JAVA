package lockandsync;
/**
 * 读读能共存
 * 读写能不能共存
 * 写写不能共存
 * 写操作：原子加独占 ，整个过程是一个完整的统一体
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


class MyCache{ //资源类
	private volatile Map<String, Object>map=new HashMap<String, Object>();
	private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
	//private Lock lock=new ReentrantLock();
	//读 写 清空
	public void put(String key,Object value) {
		readWriteLock.writeLock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t 正在写入："+key);
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put(key,value);
			System.out.println(Thread.currentThread().getName()+"\t  写入完成");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			readWriteLock.writeLock().unlock();
		}

	}
	public void get(String key) {
		readWriteLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t 正在读取："+key);
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object result = map.get(key);
			System.out.println(Thread.currentThread().getName()+"\t  读取完成");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			readWriteLock.readLock().unlock();
		}

	}
	
}
public class ReadWriteLockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCache myCache = new  MyCache();
		for (int i = 1; i <= 5; i++) {
			final int tempInt=i;
			new  Thread(()->{
			myCache.put(tempInt+"", tempInt+"");
			},String.valueOf(i)).start();
		}
		for (int i = 1; i <= 5; i++) {
			final int tempInt=i;
			new  Thread(()->{
			myCache.get(tempInt+"");
			},String.valueOf(i)).start();
		}
	
	}

}
