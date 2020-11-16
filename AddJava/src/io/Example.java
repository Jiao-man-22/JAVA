package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example {

	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		// TODO Auto-generated method stub
		//定义文件输入流
		try {
			fis = new FileInputStream("D:\\SSM\\example.log");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//定义文件输出流
		try {
			 fos = new FileOutputStream("D:\\target.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//定义缓冲区
		byte[] buff=new byte[1024];
		//int[] iuff=new int[123];
		//定义len 记录读入缓冲区的字节数
		int len;
		long beginTime = System.currentTimeMillis();
		//用缓冲流读取文件
		try {
			while((len=fis.read(buff))!=-1) {
				fos.write(buff,0,len );
			}
			long endTime = System.currentTimeMillis();
			System.out.print("拷贝文件所消耗的时间："+(endTime-beginTime)+"毫秒");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//闭流
		try {
			fis.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
