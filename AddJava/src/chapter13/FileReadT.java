package chapter13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadT {

	public static void main(String[] args) throws Exception {
		File file = new File("d:"+File.separator+"order.txt");
		try {
			FileReader fr = new FileReader(file);
			int b=0;
			try {
				while((b=fr.read())!=-1) {
				System.out.print((char)b);	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
