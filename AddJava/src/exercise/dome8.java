package exercise;
/**
 * 比大小
 * 获得最大的值
 * */
public class dome8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,1,6,9,3,8,10};
		getMax(arr);
	}
	public static void getMax(int[] arr) {
		int max=arr[0];
		for(int i=0;i<arr.length-1;i++) {
			if(max<arr[i+1]) {
				max=arr[i+1];
			}
		}
		System.out.print(max);
	}

}
