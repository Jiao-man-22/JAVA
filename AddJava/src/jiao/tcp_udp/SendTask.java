package jiao.tcp_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SendTask implements Runnable{
	private int sendPort;
	
	public SendTask(int sendPort) {
		this.sendPort=sendPort;
	}

	@Override
	public void run() {
		//1 创建一个datagramSocket对象
		try {
			DatagramSocket ds = new DatagramSocket();
			//2 输入要发送的数据
			 Scanner sc = new Scanner(System.in);
			while(true) {
				//获取从键盘输入
				String data = sc.next();
				//3.将数据封装到datagramPacket对象中的
				byte[] buf = data.getBytes();
				try {
					DatagramPacket dp = new  DatagramPacket(buf, buf.length,InetAddress.getByName("127.0.0.255"),sendPort);
					try {
						ds.send(dp);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (UnknownHostException e) {
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
