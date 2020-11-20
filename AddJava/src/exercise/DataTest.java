package exercise;

import java.util.ArrayList;

public class DataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<StudentData> arrayList = new ArrayList<StudentData>();
		StudentData data = new StudentData("张三", 15);
		StudentData data2 = new StudentData("李四", 16);
		arrayList.add(data);
		arrayList.add(data2);
		StudentData data3 = arrayList.get(1);
		System.out.print(data3.getName()+"======"+data3.getAge());
		
		

	}

}
