package chapter13;

import java.io.File;
import java.io.RandomAccessFile;


public class RandomAceessFileT1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("d:"+File.separator+"test.txt");
		RandomAccessFile rdf=null;
		rdf = new RandomAccessFile(f, "rw");
		String name=null;
		int age=0;
		name="aaaaaaaaa";
		age=30;
		rdf.writeBytes(name);
		rdf.writeInt(age);
		name="bbbb    ";
		age=31;
		rdf.writeBytes(name);
		rdf.writeInt(age);
		name="ccccc   ";
		age=32;
		rdf.writeBytes(name);
		rdf.writeInt(age);
		rdf.close();
		
	}

}
