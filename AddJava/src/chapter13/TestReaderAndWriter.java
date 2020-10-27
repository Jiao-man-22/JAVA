package chapter13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class TestReaderAndWriter {

	public static void main(String[] args) throws Exception {
		FileWriter fw=null;
		FileReader fr=null;
		// TODO Auto-generated method stub
		File srcFile=new File("d:"+File.separator+"AAA.txt");
		File destFile = new File("d:"+File.separator+"BBB.txt");
		try {
		 fr = new FileReader(srcFile);
		 fw =new FileWriter(destFile);
		 //数据的都读入写出操作
		 char[] cbuff=new char[5];
		 int  len;
		 //读到缓冲中
		 while((len=fr.read(cbuff))!=-1) {
			 fw.write(cbuff, 0, len);
		 }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fr !=null||fw!=null ) {
				fr.close();
				fw.close();
			}
		}

	}

}
