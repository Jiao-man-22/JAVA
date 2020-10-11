package chapter13;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutStreamT1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("d:"+File.separator+"test.txt");
		OutputStream out=null;
		out=new FileOutputStream(f);
		String str="Hello wrold";
		//由于只能使用字节数组只能 将字符转化为字节数组
		byte[] bytes = str.getBytes();
		out.write(bytes);
		out.close();
		
		

	}

}
