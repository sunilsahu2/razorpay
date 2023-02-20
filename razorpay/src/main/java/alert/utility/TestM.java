package alert.utility;

import java.util.HashMap;
import java.util.Objects;

public class TestM {

	public static void main(String[] args) {
		HashMap<String, UserBean>  map1=new HashMap<String, UserBean>();
		HashMap<String, UserBean>  map2=new HashMap<String, UserBean>();
		map1.put("12", null);
		map1.put("1", null);
		map1.put("2", null);
		map1.put("3", null);
		map1.put("4", null);
		
		map2.put("1", null);
		map2.put("2", null);
		map2.put("3", null);
		map2.put("12", null);
		
		HashMap<String, UserBean>  map3=removeDuplicates2(map2,map1);

		System.out.println("MAP 3 "+map3);
		
		
	}
	public static HashMap<String, UserBean> removeDuplicates2(HashMap<String, UserBean> vocab,HashMap<String, UserBean> target) {
		HashMap<String, UserBean> result = new HashMap<String, UserBean>(target);
for (String key: vocab.keySet()) {
result.compute(key, (k, v) -> !Objects.equals(v, vocab.get(k)) ? v : null);
}
return result;
}
}
