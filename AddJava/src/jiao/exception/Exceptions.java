package jiao.exception;
/**
* һ��null�Ǵ���ȷ���Ķ���,�������ֲ��Ƕ���,ȴ������Object������  ��֤0-1
* ����JavaĬ�ϸ�������ֵ
�ڶ��������ʱ����������û�и�������ֵ����Java������ʱ���Զ���������ֵ����ֵԭ������������int��byte��short��long���Զ���ֵΪ0����С�����float��double�Զ���ֵΪ0.0��boolean���Զ���ֵΪfalse�����������������ͱ����Զ���ֵΪnull��
����������ͨ������������
�ġ�����������null
List�������ظ�Ԫ�أ����Լ���������null��
Set���������ظ�Ԫ�أ������Լ���һ��null��
Map��Map��key�����Լ���һ��null��value�ֶ�û�����ơ�
���飺�����������飬����������������ʼֵ����java����ʱ���Զ�����ֵ�������������飬��������ʼֵ�������е�Ԫ��ֵΪnull��
 �塢null����������
1���ж�һ���������������Ƿ�null�� ��==���жϡ�
2���ͷ��ڴ棬��һ����null���������ͱ���ָ��null�������������Ͳ��ٱ��κζ���Ӧ���ˡ��ȴ�JVM�������ջ���ȥ���ա�
* */

public class Exceptions {
	public static void isObject(Object x) {
		
		if(x instanceof java.lang.Object) {
			System.out.println("null Ϊ ����");
		}else {
			System.out.println("null ��Ϊ ����");
		}
	}
	//main���κΣ��������治�ܶ��巽�� ���Ե��÷���
	public static void main(String[] args) {
		//new Exceptions().isObject(null);
		
		
		
		
	}
	
	

}
