package jiao.testserialiaable;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * ���л�
	 * ��һ�������ΪΪ�������������ķ��� ʵ�ֶԶ���Ĵ���ʹ��� ��Ҫʵ�����л�����ʵ��Serializable�ӿ�
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


	private String name;
	private int age;
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	public Person(String string, int i) {
		
	}

}
