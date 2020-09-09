package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamDemo {
	public static void main(String[] args) {
		File f = new File("C://temp.txt");
		OutputStream out=null;
		try {
			out=new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] b="hello word!!!!".getBytes();
		//将b写入文件之中 
		try {
			out.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream in=null;
		
		try {
			//创立输入流连接
			in=new FileInputStream(f);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//开辟一块空间来接受传来的数据 
		byte[] b1=new byte[1024];
		int i=0;
		try {
			i=in.read(b1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将byte数组转化为字符串输出
		System.out.println(new String(b1,0,i));
		
	}

}
