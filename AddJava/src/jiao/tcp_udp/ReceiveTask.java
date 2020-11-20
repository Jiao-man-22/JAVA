package jiao.tcp_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveTask implements Runnable{
	private int receivePort;
	
	public ReceiveTask(int receivePort) {
		this.receivePort=receivePort;
	}

	@Override
	public void run() {
		try {
			//DatagramSocket对象
			DatagramSocket ds = new DatagramSocket(receivePort);
			//创建datagramPacket对象
			byte[] buf=new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			//接受数据
			while(true) {
				try {
					ds.receive(dp);
					//显示接受的数据
					String str = new String(dp.getData(),0,dp.getLength());
					System.out.println("收到"+dp.getAddress().getHostAddress()+"---发送的数据------"+str);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
