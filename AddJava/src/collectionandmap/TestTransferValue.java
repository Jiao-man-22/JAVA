package collectionandmap;

public class TestTransferValue {
	static int age =20;
	public void changValue1(int age) {
		age=30;
		System.out.println("方法中的 age:"+age);
	}
	public void changValue2(Person person) {
		person.setPersonName("xxx");
	}
	public void changValue3(String str) {
		str="xxx";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestTransferValue test = new TestTransferValue();
		
		//基本变量的传值 是副本拷贝
		test.changValue1(age);
		System.out.println("age------"+age);//20
		//引用类型传的是指针或引用
		Person person=new Person("abc");
		test.changValue2(person);
		System.out.println("personName------"+person.getPersonName());//xxx
		//String 有常量池   赋值时会先在常量池中查找字符 有就指向 没有就生成
		String str="abc";
		String str2="abc";
		String str3=new String("abc");
		test.changValue3(str);
		System.out.println(str==str2);
		//System.out.println("比较是否同一个字符串："+str.equals(str2));
		//System.out.println("比较是否同一个字符串："+str==str3);
		System.out.println("String------"+str);//abc
	}

}
