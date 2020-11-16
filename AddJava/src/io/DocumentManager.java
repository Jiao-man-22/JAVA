package io;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DocumentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner	sc=new Scanner(System.in);
	System.out.print("--1：指定关键字检索文件   2：指定后缀检索文件"+"3:复制文件/目录"+"4:退出--");
	while(true) {
		System.out.print("请输入指令：");
		int command = sc.nextInt();
		switch (command) {
		case 1:
//			searchByKeyWord();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			System.out.println("您输入的指令有误");
			break;
		}
	}
	}
	//*******************1.指定关键字的检索文件********************************
	private static void searchByKeyWord() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入要检索的文件");
		String path = scanner.next();
		File file = new File(path);
		if(!file.exists()|| !file.isDirectory()) {
			System.out.print(path+"不是有效目录");
			return;
		}
		System.out.print("请输入关键字：");
				String key = scanner.next();
				ArrayList<String> listFiles = FileUtil.listFiles(file,key);
				for(Object obj:listFiles) {
					System.out.print(obj);
				}
	}

}
