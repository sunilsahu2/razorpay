package alert.utility;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class DataExtract {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		 String filealluserdata="D:\\funngro\\recon\\User data complete.csv";
		 String fileuseractivity="D:\\funngro\\recon\\Funngro (98).csv";
		 ArrayList<String> alistalluserdata= ReadCSV.getArrayList(filealluserdata);
		 System.out.println(alistalluserdata);
		 
		 DataExtract.extractDataFromUser(alistalluserdata);
	
		ArrayList<String> alistuseractivity= ReadCSV.getArrayList(fileuseractivity);
		 System.out.println(alistuseractivity);
		 DataExtract.extractDataFromUserActivity(alistuseractivity);
	}
	
	public static HashMap <String,UserBean> extractDataFromUser(ArrayList<String> alist){
		HashMap <String,UserBean> alistresult=new HashMap <String,UserBean>();
		UserBean objUserBean=null;
		int i=1;
		for(String s:alist) {
			objUserBean=new UserBean();
		//	System.out.println("USER "+i+": "+s);
			String arr[]=s.split(",");
			if(arr[3].equalsIgnoreCase("email")) {
				System.out.println("header skipped "  );
			}else {
			objUserBean.setMailId(arr[3]);
			objUserBean.setMobile(arr[2]);
			objUserBean.setName(arr[1]);
			objUserBean.setRole(arr[5]);
			if(arr[5].equalsIgnoreCase("Child"))
			alistresult.put(objUserBean.getMobile(),objUserBean);
			//alistresult.put(objUserBean.getMobile(),null);
			}
		i++;
		}
		//System.out.println(alistresult  );
		return alistresult;
	}
	public static HashMap <String,UserBean>  extractDataFromUserActivity(ArrayList<String> alist){
		HashMap <String,UserBean> alistresult=new HashMap <String,UserBean>();
		UserBean objUserBean=null;
		int i=0;
		for(String s:alist) {
			objUserBean=new UserBean();
			//System.out.println("USERActoivity "+i+": "+s);
			String arr[]=s.split(",");
			if(arr[3].equalsIgnoreCase("*EMAIL")) {
				System.out.println("header skipped "  );
			}else {
			objUserBean.setMailId(arr[3]);
			objUserBean.setMobile(arr[4]);
			objUserBean.setName(arr[1]);
			objUserBean.setEvaluation(arr[6]);
			objUserBean.setInterest(arr[7]);
			//alistresult.put(objUserBean.getMobile(),null);
			alistresult.put(objUserBean.getMobile(),objUserBean);
			}
			i++;
		}
		System.out.println(alistresult  );
		return alistresult;
	}


}
