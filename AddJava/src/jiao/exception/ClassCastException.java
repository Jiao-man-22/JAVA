package jiao.exception;
/**
 * ����ת��
 * ����ת���е;�����߾���ת�� ϵͳ�����Զ�ִ��
 * �ɸ߾�����;�����Ҫ��ʾת�� ��ǿ�� ִ�� ����ɾ��ȶ�ʧ  
 * ��ʾת��
 * int x=(int)f;
 * ��ʽת��
 * ClassCastException����֮��ת����ͻ
 * questions
 * 1 String Ϊʲô ����ǿ��ת int 
 * ��ת�� (��������ָ���������)
 * ����ʵ���ĸ�����  ��һ�����嵽����Ĺ��� ���ǰ�ȫ��  
 * Parent parent=new Children();
 * ��ת�ͣ�����һ�㲻��ʹ��
 * �����ʵ���ĸ�������� ,�ɳ��󵽾�����ڰ�ȫ����      ClassCastExcption ���� ǿת��������
 * Children children=(Children)new Parent();
 * */
class  Parent{
  
	public void draw(Parent p){
		System.out.println("Parent��"+p);
	}
}

class Children extends Parent {
//	public void draw(Children c){
//		System.out.println("Chidren:"+c);
//	}
}

public class ClassCastException {
	
	//���Object===��int ��ͻ�쳣
	public static void resolveObjectCastIntException(Object ob) {
		if(ob!=null) {
			//ת��Ϊ String ��ת int 
			String s=(String)ob;
			int i =Integer.parseInt(s);
			System.out.println(i);	
		}
	}
	
	
	public static void classCast(String s) {
		String a=s;
		Integer b=Integer.parseInt(s);
		System.out.println(b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���������ַ��� ת��Ϊ ���λᱨ�� ����
		//java.lang.NumberFormatException
		//String s="123";
//		new ClassCastException().classCast(s);
		//��objectתΪ int �ᱨ�� ����
		//java.lang.ClassCastException:
		//Object ob = new Object();
		//ob="123";
		//Object ob2=new Object();
		//ob2=123;
		//System.out.println(ob);
//		System.out.println(i);
		//��ob ת��ΪString ��תΪ int
		//String str=String.valueOf(ob);
		//int i=Integer.parseInt(str);
		//System.out.println(str instanceof String);
		//System.out.println(i);
		//System.out.println(i);
		//���� ���ȶ�ʧ���� 
		//�͵��� ���Զ�ִ����ʽת��
		//int x=10;
		//float f=x;
		//System.out.println(f);
		//�ߵ��� 
		//float f=15.0f;
		//int x=(int)f;
		//System.out.println(x);
		//���� Object ==��int
		//System.out.print(s instanceof String);
		//System.out.println(ob instanceof String);
		//resolveObjectCastIntException(ob);
		//if (ob2 instanceof Integer) {
		//	System.out.println(ob2);
		//}
		//Children children = new Children();
		//System.out.println(children instanceof Parent);
		//children.draw(children);
		Parent parent2 = new Parent();
		Children children=new Children();
		//��ת�ͣ�ֱ��ת �ᱨ ClassCastException
//		Children c=(Children) new Parent();
		//������ת��
//		if(c instanceof Children) {
//			System.out.println("c�� Children��ʵ��" +c);
//		}
//		if(c instanceof Parent) {
//			System.out.println("c�� Parent��ʵ��"+c);
//		}
		if(parent2 instanceof Parent) {
			System.out.println("parent2������Parent��ʵ�� " +parent2);
		}
		if(parent2 instanceof Children) {
			//����ת��
			Children child=(Children)parent2;
			
			System.out.println("parent2��Children ��ʵ�� "+child);
		}
		if (children instanceof Parent) {
			//��ת��
			Parent p=children;//
			if(p instanceof Children) {
				System.out.println("����pΪChilren��ʵ��"+p);
			}
			if(p instanceof Parent) {
				System.out.println("����pΪ Parent��ʵ��"+p);
			}
			System.out.println("children��Parent ��ʵ�� "+children);
		}
		if (children instanceof Children) {
			System.out.println("children��Children ��ʵ�� "+children);
		}
		
		
		
		
		
		
	}

}
