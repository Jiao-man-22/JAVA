package exercise;
/*
 * 二维数组的创建与遍历
 * */
public class dome4 {
	public static void ergodicArray() {
		int[][] Aa= {
				{11,12,23,24},
				{15,16,27,18},
				{19,10,17,18},
				{13,14,15,16},
				{17,18,19,20}
				};
		for(int i=0;i<Aa.length;i++) {
			for(int j=0;j<Aa[i].length;j++) {
				System.out.print("Aa"+"["+i+"]"+"["+j+"]"+"="+Aa[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static int[] sort(int[] array) {
		//先遍历再比较
		for(int i=0;i<array.length-1;i++) {
			int max=array[0];
			while(max<array[i+1]) {
				array[i]=max;
				max=array[i+1];
			}
		}
		return array;
	}
	public static void printArray(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
	}
	public static void main(String[] args) {
		//ergodicArray();
		int [] array=new int[]{-1,-9,-2,-3,2,0,8,6,4,5};
		int[] sortArray = sort(array);
		printArray(sortArray);
	}

}
