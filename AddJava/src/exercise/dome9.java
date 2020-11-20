package exercise;
/*
 * 冒泡排序
 * */
public class dome9 {
	
	public static void main(String[] args) {
		int[] arr= {9,8,3,5,2};
		System.out.println("冒泡排序前：");
		printArray(arr);
		System.out.println("冒泡排序后：");
		bubbleSort(arr);
	}
	public static void printArray(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}
	//冒泡排序
	public static void bubbleSort(int[] array) {
		int max;
		//外层循环：每次定位一个数
		for(int i=0;i<array.length-1;i++) {
		//内层循环比较次数	
		for(int j=0;j<array.length-i-1;j++) {
			if(array[j]>array[j+1]) {
				max=array[j];
				array[j]=array[j+1];
				array[j+1]=max;
			}	
		}
		}
		printArray(array);
	}
}
