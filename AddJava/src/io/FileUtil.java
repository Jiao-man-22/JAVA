package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
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
	/**
	 * 指定后缀名检索文件
	 * @param file File
	 * @param suffixArray
	 * @return 指定后缀的文件路径 
	 * */
	public static ArrayList<String> listFiles(File file,final String[] suffixArray){
		FilenameFilter filter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				File currFile = new File(dir,name);
				if(currFile.isFile()) {
					for(String suffix:suffixArray) {
						if(name.endsWith("."+suffix)) {
							return true;
						}
					}
				}
				return false;
			}
		};
		ArrayList<String> arraylist = fileDir(file,filter);
		return arraylist;
		
	}
	/**
	 * @param srcFile源文件
	 * @param destFile目标目录
	 * @throws IOException 
	 * */
	public static void copySrcPathToDestPath(File srcDir,File destDir) throws IOException {
		File[] files = srcDir.listFiles();
		for(int i=0;i<files.length;i++) {
			File copyedFile = new File(destDir,files[i].getName());
			if(files[i].isDirectory()) {
				if(!copyedFile.mkdirs()) {
					System.out.print("无法创建文件夹;"+copyedFile);
					return;
				}
				copySrcPathToDestPath(files[i], copyedFile);
			}else {
				//复制文件
				FileInputStream input = new FileInputStream(files[i]);
				FileOutputStream output = new FileOutputStream(copyedFile);
				byte[] buffer=new byte[1024];
				int n=0;
				while((n=input.read(buffer))!=-1) {
					output.write(buffer, 0, n);
				}
				input.close();
				output.close();
			}
		}
	}
}
