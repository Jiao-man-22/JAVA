package jiao.testserialiaable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;


public class SerT2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("D:"+File.separator+"test.txt");
		ObjectInputStream ois=null;
		InputStream input = new FileInputStream(file);
		ois=new ObjectInputStream(input);
		Object in = ois.readObject();
		ois.close();
		System.out.println(in);
		
		

	}

}
