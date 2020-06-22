package jiao.testserialiaable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerT1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new  File("D:"+File.separator+"test.txt");//自定义保存路径
		ObjectOutputStream oos=null;
		//对象输出流
		OutputStream out=new FileOutputStream(file);
		oos=new ObjectOutputStream(out);
		oos.writeObject(new Person("张三",30));
		oos.close();
		
		
		
		
	}

}
