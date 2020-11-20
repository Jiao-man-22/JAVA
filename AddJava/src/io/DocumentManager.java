package io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DocumentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner	sc=new Scanner(System.in);
	System.out.println("--1：指定关键字检索文件   2：指定后缀检索文件"+"3:复制文件/目录"+"4:退出--");
	while(true) {
		System.out.print("请输入指令：");
		int command = sc.nextInt();
		switch (command) {
		case 1:
			searchByKeyWord();
			break;
		case 2:
			searchBySuffix();
			break;
		case 3:
			try {
				copyDirectory();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			exit();
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
		System.out.println(file.getAbsolutePath());
		if(!file.exists() || !file.isDirectory()) {
			System.out.println(path+"不是有效目录");
			return;
		}
		
		System.out.print("请输入关键字：");
				String key = scanner.next();
				ArrayList<String> listFiles = FileUtil.listFiles(file,key);
				for(Object obj:listFiles) {
					System.out.println(obj);
				}
	}
	//*********************2.指定后缀检索文件*********************************
	private static void searchBySuffix() {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入要检索的目录位置：");
		String path = sc.next();
		File file = new File(path);
		if(!file.exists() ||!file.isDirectory()) {
			System.out.print(path+"这不是有效路径");
			return;
		}
		System.out.print("请输入搜索后缀：");
		String suffix = sc.next();
		String[] suffixArray = suffix.split(",");
		ArrayList<String> list = FileUtil.listFiles(file, suffixArray);
		for(Object obj:list) {
			System.out.println(obj);
		}
	}
	//********************3复制文件***********************
	private static void copyDirectory() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入原文件");
		String srcDirectory = sc.next();
		//File 映射磁盘上的文件或者文件夹不管起是否真的存在磁盘中
		File srcFile = new File(srcDirectory);
		if(!srcFile.exists()||!srcFile.isDirectory()) {
			System.out.println("无效目录");
			return;
		}
		System.out.print("请输入目标位置：");
		String destDirectory = sc.next();
		File destFile=new File(destDirectory);
		if(!destFile.exists()||!destFile.isDirectory()) {
			System.out.println("无效位置");
			return;
		}
		FileUtil.copySrcPathToDestPath(srcFile, destFile);
	}
	//******************4.退出*****************************//
	private static void exit() {
		System.out.println("您已退出系统，谢谢使用！");
		System.exit(0);
	}
}
