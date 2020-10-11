package chapter13;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/*
 * 管道流:可以实现两个线程之间通信；
 * */
class Send implements Runnable{
	private PipedOutputStream pos=null;
	public Send() {
		//实例化输出流 
		this.pos=new PipedOutputStream();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String str="Hello world =====";
		try {
			this.pos.write(str.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.pos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public PipedOutputStream getPos() {
		return this.pos;
	}
}
class Receive implements Runnable{
	private PipedInputStream pis=null;
	public Receive() {
		//实例化 输入流 
		this.pis=new PipedInputStream();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//接受内容
		byte [] b=new byte[1024];
		int len=0;
		try {
			//读取内容 
			len=this.pis.read(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.pis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("接收的内容为："+new String(b,0,len));
	}
	public PipedInputStream  getPis() {
		return this.pis;
	}
	
}
public class Guan {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Send s = new Send();
		Receive r = new Receive();
		//连接管道
		s.getPos().connect(r.getPis());
		new Thread(s).start();
		new Thread(r).start();
	}

}
