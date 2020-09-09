package io;

import java.io.File;
import java.io.IOException;

/*
 *file类是io包下唯一代表此【盘本身的对象 file类定义了与平台无关的方法来操作文件  创建 删除 和权限读取 如果 在windows/dos 中使用反斜线 \ 就需要
 *使用它的转义反斜线 \\但对于斜线 /  和//可以通用。反斜线就要求转义
 */
public class IoIntroduction {
	public static void main(String[] args) {
		File f = new File("C:\\4.txt");
		if(f.exists()) {
			f.delete();
		}else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(f.getAbsolutePath());
			System.out.println(f.getName());
			System.out.println(f.canRead());
		}
	}
 
	

}
