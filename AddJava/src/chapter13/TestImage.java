package chapter13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/*
 * 文件输出流
 * 
 * */
public class TestImage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream  fis=null;
		FileOutputStream fos=null;
		//创建目标文件对象
		File srcFile = new File("d:"+File.separator+"墙.jpg");
		File destFile = new File("d:"+File.separator+"墙2.jpg");
		//造流
		fis =new FileInputStream(srcFile);
		fos =new FileOutputStream(destFile);
		//读写
		byte [] buffer =new byte[5];
		int len;
		while((len=fis.read(buffer))!=-1) {
			fos.write(buffer,0,len);
		}
		//闭流
		fis.close();
		fos.close();
		
		
		
		

	}

}
