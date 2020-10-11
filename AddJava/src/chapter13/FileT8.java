package chapter13;

import java.io.File;

public class FileT8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("e:"+File.separator);
		String[] list = f.list();
		for(String s:list){
			System.out.println(s);
		}		
	}

}
