package chapter13;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamT3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("d:"+File.separator+"test.txt");
		InputStream input=null;
		input=new FileInputStream(f);
		byte[] b=new byte[(int)f.length()];
		//放回被读取数据的长度
		int len = input.read(b);
		input.close();
		System.out.print("读取数据的长度="+len+"\t");
		System.out.print(new String(b));
		
		
		

	}

}
