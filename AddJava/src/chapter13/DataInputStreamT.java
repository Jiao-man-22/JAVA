package chapter13;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStreamT {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		DataInputStream dis=null;
		File f = new File("d:"+File.separator+"order.txt");
		dis=new DataInputStream(new FileInputStream(f));
		System.out.print(f.length()+"\n");
		String name=null;
		float price=0.0f;
		int num=0;
		char temp[] =null;
		//接受数据个数
		int len=0;
		char c=0;
		temp=new char[1024];
		len=0;
		try {
			while(true) {
				while((c=dis.readChar())!='\t') {
					//接收内容
					temp[len]=c;
					//读取长度加一
					len++;
				}
				//将字符数组转为String
				name=new String(temp,0,len);
				//读取价格
				System.out.println(name);
				price=dis.readFloat();
				//读取\t
				dis.readChar();
				//读取数量
				num=dis.readInt();
				//读取\n
				dis.readChar();
				System.out.printf("名称：%s; 价格：%5.2f  数量：%d\n",name,price,num);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
