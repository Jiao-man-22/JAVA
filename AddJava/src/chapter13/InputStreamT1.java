package chapter13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamT1 {
	public static void main(String[] args) throws IOException {
		File f = new File("d:"+File.separator+"test.txt");
		InputStream input=null;
		try {
			input=new FileInputStream(f);
			byte [] b=new byte[1024];
			input.read(b);
			input.close();
			System.out.print(new String(b));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
