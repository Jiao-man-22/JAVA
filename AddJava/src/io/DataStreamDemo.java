package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {
	public static void main(String[] args) throws IOException {
		//将数据写入摸个载体
		DataOutputStream out = new DataOutputStream(new FileOutputStream("order.txt"));
		//价格		
		double[] prices= {18.22,9.22,14.22,5.22,4.21};
		//数目
		int[] units= {10,10,29,39,40};
		String[] descs= {"T恤衫","杯子","大头这","洋娃娃","钥匙链"};
		//向数据过滤流中写入主要类型
		for (int i = 0; i <prices.length; i++) {
			//写入价格并使用tab键隔开
			out.writeDouble(prices[i]);
			out.writeChar('\t');
			//写入数量
			out.writeInt(units[i]);
			out.writeChar('\t');
			//写入名称并换行
			out.writeChars(descs[i]);
			out.writeChar('\n');
		}
		//关闭输出流
		out.close();
		//将数据读出来
		DataInputStream in = new DataInputStream(new FileInputStream("order.txt"));
		double price;
		int unit;
		StringBuffer desc;
		double total=0.0;
		try {
			//当文本被全部读出以后会抛出 EOFException
			while(true) {
				//读出价格，数量，名称,
				price=in.readDouble();
				//跳过tab
				in.readChar();
				unit=in.readInt();
				in.readChar();
				//读出产品名称
			char chr;
			desc=new StringBuffer();
			while((chr=in.readChar())!='\n') {
				desc.append(chr);
			}
			System.out.println("订单信息"+"产品名称："+desc+",\t 数量："
					+unit+"\t价格："+price);
			total=total+unit*price;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("\n总共需要："+total);
		}
		in.close(); 
		
	}

}
