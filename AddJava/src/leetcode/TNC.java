package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TNC {
	//暴力破解
	public static String twoNumCount(int[] nums, int num) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == num) {
					return "[" + i + "," + j + "]";
				} else {
					continue;
				}
			}
		}
		return "数据返回失败";
	}
	//使用map
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
        	//判断key值是否存在
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }



	public static void main(String[] args) {
		int[] arr = { 3,2,4};
		System.out.print(twoNumCount(arr, 6));
	}
}
