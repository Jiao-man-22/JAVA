package jiao.tcp_udp;

import java.util.Scanner;

public class ChatRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("欢迎您加入聊天室");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入发送的端口号");
		int sendPort = sc.nextInt();
		System.out.println("请输入接受的端口号");
		int receivePort = sc.nextInt();
		System.out.println("聊天系统启动！！！");
		new Thread(new SendTask(sendPort));
		new Thread(new ReceiveTask(receivePort));
		

	}

}
