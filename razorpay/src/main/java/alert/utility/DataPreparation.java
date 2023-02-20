package alert.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataPreparation {
	public static Map<String,UserBean> extractCase1Data(HashMap<String,UserBean> alistuser,HashMap<String,UserBean>alistactivity){
		Map<String,UserBean> objresult=new HashMap<String,UserBean>();
		System.out.println("alistuser "+alistuser);
		System.out.println("alistactivity "+alistactivity);
		objresult=removeDuplicates2(alistactivity,alistuser);
		//objresult=removeDuplicates(alistuser,alistactivity);
		System.out.println("alistuser "+objresult.keySet());
		return objresult;
	}
	
	public static HashMap<String,UserBean> extractCase2Data(HashMap<String,UserBean> alistuser,HashMap<String,UserBean>alistactivity){
		HashMap<String,UserBean> objresult=new HashMap<String,UserBean>();
		System.out.println("alistuser "+alistuser);
		System.out.println("alistactivity "+alistactivity);
		objresult=removeDuplicates(alistuser,alistactivity);
		
		return objresult;
	}
	
	public static HashMap<String, UserBean> removeDuplicates(HashMap<String, UserBean> first,HashMap<String, UserBean> second) {
					HashMap<String, UserBean> result = new HashMap<>(first);
					//System.out.println("result1  "+result);
					for (String key: first.keySet()) {
						System.out.println("result1  "+result);
						//System.out.println("key  "+key);
						if(second.keySet().contains(key)) {
							result.remove(key);       
						}
						
						
					}
					System.out.println("result2  "+result);
			return result;
		}
	
	
	public static Map<String, UserBean> removeDuplicates2(HashMap<String, UserBean> vocab,HashMap<String, UserBean> target) {
		Map<String, UserBean> result = new HashMap<String, UserBean>(target);
		
		System.out.println( vocab.keySet()  );
		System.out.println( target.keySet()  );
		
		for (String key: vocab.keySet()) {
		//result.compute(key, (k, v) -> !Objects.equals(v, vocab.get(k)) ? v : null);
			result.compute(key, (k, v) ->  !vocab.containsKey(k)?v:null);
		}
		Map<String, UserBean> result2=result.entrySet().stream().filter(map->(result.get(map.getKey())).getRole().equalsIgnoreCase("Child")).collect(Collectors.toMap(map -> map.getKey(), map -> (UserBean)map.getValue())); 
		
	//	 .filter(c -> City.getFrom().equals("city1"))
		
return result2;
}
	
	
	public static Map<String, UserBean> getEvaluateDataFalse(HashMap<String, UserBean> second) {
		
		Map<String, UserBean> result2=second.entrySet().stream().filter(map->(second.get(map.getKey())).getEvaluation().equalsIgnoreCase("FALSE")).collect(Collectors.toMap(map -> map.getKey(), map -> (UserBean)map.getValue())); 
		
		
		return result2;
	}
	
	
public static Map<String, UserBean> getEvaluateDataTrue(HashMap<String, UserBean> second) {
		
		Map<String, UserBean> result2=second.entrySet().stream().filter(map->(second.get(map.getKey())).getEvaluation().equalsIgnoreCase("TRUE")).collect(Collectors.toMap(map -> map.getKey(), map -> (UserBean)map.getValue())); 
		
		
		return result2;
	}
	
	
	public static HashMap<String, HashMap<String, UserBean>> getEvaluateData(HashMap<String, UserBean> second) {
		HashMap<String, UserBean> resultfalse = new HashMap<>();
		HashMap<String, UserBean> resulttrue = new HashMap<>();
		HashMap<String, HashMap<String, UserBean>> objfinalre=new HashMap<String, HashMap<String, UserBean>>();
		//System.out.println("result1  "+result);
		for (String key: second.keySet()) {
			UserBean objUserBean=second.get(key);
			if(objUserBean.getEvaluation().equalsIgnoreCase("false")) {
				resultfalse.put(key, objUserBean);
			}else if(objUserBean.getEvaluation().equalsIgnoreCase("true")){
				resulttrue.put(key, objUserBean);
			}
				
			
		}
		objfinalre.put("true", resulttrue);
		objfinalre.put("false", resultfalse);
		System.out.println("objfinalre  "+objfinalre);
		return objfinalre;
}
}
