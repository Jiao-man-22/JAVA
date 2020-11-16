package io;

import java.io.File;

public class Example14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("D:\\newDir");
		fileDir(file);
	}
	static void fileDir(File dir) {
		//获得表示目录下所有的文件数组
		File[] files = dir.listFiles();
		//遍历所有的子目录和文件
		for(File f:files) {
			if(f.isDirectory()) {
				//递归调用
				fileDir(dir);
			}
			System.out.println(f.getAbsolutePath());
			
		}
		
	}

}
