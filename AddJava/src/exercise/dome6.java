package exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 遍历map集合
 * */
public class dome6 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("zs", "nan");
		map.put("ls", "nan");
		map.put("ww", "nv");
		for(String s:map.keySet()) {
			System.out.println(s+":"+map.get(s));
		}
		
		//放回set视图 一个map对象
		for(Map.Entry<String, String> entry: map.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

}
