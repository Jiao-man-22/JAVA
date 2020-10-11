package chapter13;

import java.io.File;
/*File类映射磁盘文件
 * 
 * */

public class FileT {
	public static void main(String[] args) {
		File file = new File("d:"+File.separator+"test.txt");
	
		
		try {	
			//file.createNewFile();
			if(file.exists())
			file.delete();
			else {
				//new File("D:"+File.separator+"www").mkdir(); 
				new File("D:"+File.separator+"www").delete();
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
