package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class FileUtil {
	/**
	 * 指定关键字检索文件
	 * @param file File对象
	 * @param key 关键字
	 * @return 包含关键字的文件路径
	 * */
	public static ArrayList<String> listFiles(File file,final String key){
		FilenameFilter filter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				File currFile = new File(dir,name);
				if(currFile.isFile()&&name.contains(key)) {
					return true;
				}
				return false;
			}
		};
		//递归方式获取路径
		ArrayList<String> arrayList = fileDir(file, filter);
		return arrayList;
		
	}
	public static ArrayList<String> fileDir(File dir,FilenameFilter filter){
		ArrayList<String> arrayList = new ArrayList<String>();
		File[] lists = dir.listFiles();
		for(File list:lists) {
			arrayList.add(list.getAbsolutePath());
		}
		File[] files =dir.listFiles();
		for(File file:files) {
			if(file.isDirectory()) {
				ArrayList<String> every = fileDir(dir, filter);
				arrayList.addAll(every);
			}
		}
		return arrayList;
		
	}
}
