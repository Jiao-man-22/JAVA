package leetcode;

public class RemoveArray {
//	 public static int removeElement(int[] nums, int val) {
//		    int j=0;
//	        for(int i=0;i<nums.length;i++){
//	            if(nums[i]!=val){
//	            	nums[j]=nums[i];
//	            	j++;
//	            }else if(nums[i]==val) {
//	            	continue;
//	            	
//	            }
//	        }
//			return j;
//	    }
	 public static int removeElement(int[] nums, int val) {
			if (nums == null || nums.length == 0)
				return 0;
			int j = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != val) {
					nums[j] = nums[i];
					j++;
				}
			}
			return j;
		}
	public static void main(String[] args) {
		int [] nums= {1,2,3,4,5};
		int val=2;
		System.out.print(removeElement(nums, val));
	}

}
