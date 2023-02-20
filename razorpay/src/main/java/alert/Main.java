package alert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import alert.utility.DataPreparation;
import alert.utility.ReadCSV;
import alert.utility.UserBean;
import alert.utility.WriteCSV;

public class Main {

	public static void main(String[] args) throws IOException {
		//Properties prop=ReadCSV.getReadProperties("D:\\funngro\\recon\\config\\config.properties");//"D:\\funngro\\recon\\config\\config.properties"
		
		Properties prop=ReadCSV.getReadProperties("config.properties");//"D:\\funngro\\recon\\config\\config.properties"
		
		String filealluserdata=prop.getProperty("SOURCE_FILE_PATH_USER");
		String fileuseractivity=prop.getProperty("SOURCE_FILE_PATH_ACTIVITY");
		String outputfolderpath=prop.getProperty("DESTINATION_FOLDER");
		String not_registered_caller_user_case1=prop.getProperty("CASE1_NOT_REGISTERED_CALLER_USER");
		String not_evaluated_caller_user_case2=prop.getProperty("CASE2_NOT_EVALUATED_CALLER_USER");
		String evaluated_caller_user_case3=prop.getProperty("CASE3_EVALUATED_CALLER_USER");
		//	String filealluserdata="D:\\funngro\\recon\\date12jan\\user (39).csv";
		//	String fileuseractivity="D:\\funngro\\recon\\date12jan\\Funngro -12jan.csv";
		//	 ArrayList<String> alistalluserdata= ReadCSV.getArrayList(filealluserdata);
			 
			 
			 //HashMap<String,UserBean> alistalluserdataUserBean=DataExtract.extractDataFromUser(alistalluserdata);
			 
			 HashMap<String,UserBean> alistalluserdataUserBean=ReadCSV.extractDataFromUser(filealluserdata);
			// System.out.println("ALL USER DATA "+alistalluserdataUserBean);
		//	 ArrayList<String> alistuseractivity= ReadCSV.getArrayList(fileuseractivity);
			 

			 HashMap<String,UserBean> alistuseractivityUserBean=ReadCSV.extractDataFromUserActivity(fileuseractivity);
			 
			// HashMap<String,UserBean> alistuseractivityUserBean=DataExtract.extractDataFromUserActivity(alistuseractivity);
			// System.out.println("ALL USERACTIVITY DATA "+alistuseractivityUserBean);
			 
			 
			 Map<String,UserBean> objCase1=DataPreparation.extractCase1Data(alistalluserdataUserBean,alistuseractivityUserBean);
			 System.out.println("CASE 1 "+objCase1);
			
			 //CASE 1 BLOCK START
			 
			 String arruser[]=not_registered_caller_user_case1.split(",");
			 List<UserBean> values = new ArrayList<UserBean>(objCase1.values()); 
			 List<String[]> exotelcase1 = new ArrayList<String[]>();
			 List<String[]> calldeskcase1 = new ArrayList<String[]>();
			 List<String[]> gupshupcase1 = new ArrayList<String[]>();
			 exotelcase1.add(new String[] { "number","first_name","last_name","company_name","email","tag","custom_field" });
			 calldeskcase1.add(new String[] { "S.NO","DESK PHONE","CONTACT NAME"," NUMBER","EMAIL ID"," ADDRESS","STATUS","DATE/TIME"," Member"," Follow-up Date"," Comment","Existing customer","Status","Past comment" });
			 gupshupcase1.add(new String[] { "PHONE","%VAR1"});//case 2 %VAR2 will be there //interest
			 int callserUserCount=0;
			 for (UserBean oUserBean: values) {
				if(oUserBean.getMobile().length()>1) {
					exotelcase1.add(new String[] { oUserBean.getMobile(),oUserBean.getName(),"","registerednotearn",oUserBean.getMailId(),"member","{ \"key:{ \"key1: values1 \"} \"}" });
					calldeskcase1.add(new String[] { "","",oUserBean.getName(),oUserBean.getMobile(),oUserBean.getMailId(),"","registerednotearn","",arruser[callserUserCount],"","","","registerednotearn",""});//CASE 1 , CASE 2 notevaluated, CASE 3 evaluated 
					gupshupcase1.add(new String[] {"91"+ oUserBean.getMobile(),oUserBean.getName()});
			}
				callserUserCount++;
				if(callserUserCount>5) {
					callserUserCount=0;
				}
				
			}
			
			 
			 WriteCSV.writeDataAtOnce(outputfolderpath+"exotel_not_registered.csv",exotelcase1);
			 WriteCSV.writeDataAtOnce(outputfolderpath+"calldesk_not_registered.csv",calldeskcase1);
			 WriteCSV.writeDataAtOnce(outputfolderpath+"gupchup_not_registered.csv",gupshupcase1);
			 
			 //CASE 1 BLOCK END
			 
			 
			 //CASE 2 BLOCK START
			 
			 
			 Map<String,UserBean> objCase2=DataPreparation.getEvaluateDataFalse( alistuseractivityUserBean);
			 
			 String arruser_not_evaluated[]=not_evaluated_caller_user_case2.split(",");
			 List<UserBean> valuesCase2 = new ArrayList<UserBean>(objCase2.values()); 
			 List<String[]> exotelcase2 = new ArrayList<String[]>();
			 List<String[]> calldeskcase2 = new ArrayList<String[]>();
			 List<String[]> gupshupcase2 = new ArrayList<String[]>();
			 exotelcase2.add(new String[] { "number","first_name","last_name","company_name","email","tag","custom_field" });
			 calldeskcase2.add(new String[] { "S.NO","DESK PHONE","CONTACT NAME"," NUMBER","EMAIL ID"," ADDRESS","STATUS","DATE/TIME"," Member"," Follow-up Date"," Comment","Existing customer","Status","Past comment" });
			 gupshupcase2.add(new String[] { "PHONE","%VAR1","%VAR2"});//case 2 %VAR2 will be there //interest
			 callserUserCount=0;
			 
			 for (UserBean oUserBean: valuesCase2) {
				if(oUserBean.getMobile().length()>1) {
					exotelcase2.add(new String[] { oUserBean.getMobile(),oUserBean.getName(),"","earnnotevaluate",oUserBean.getMailId(),"member","{ \"key:{ \"key1: values1 \"} \"}" });
					calldeskcase2.add(new String[] { "","",oUserBean.getName(),oUserBean.getMobile(),oUserBean.getMailId(),"","notevaluated","",arruser_not_evaluated[callserUserCount],"",oUserBean.getInterest(),"","notevaluated",""});//CASE 1 , CASE 2 notevaluated, CASE 3 evaluated 
					gupshupcase2.add(new String[] {"91"+ oUserBean.getMobile(),oUserBean.getName(),oUserBean.getInterest()});
			}
				
				callserUserCount++;
				if(callserUserCount>5) {
					callserUserCount=0;
				}
			}
			
			 
			 
			 WriteCSV.writeDataAtOnce(outputfolderpath+"exotel_not_EVALUATED.csv",exotelcase2);
			 WriteCSV.writeDataAtOnce(outputfolderpath+"calldesk_not_EVALUATED.csv",calldeskcase2);
			 WriteCSV.writeDataAtOnce(outputfolderpath+"gupchup_not_EVALUATED.csv",gupshupcase2);
			
			 //CASE 2 BLOCK END
			 
			 
			 //CASE 3 BLOCK START
			 Map<String,UserBean> objCase3=DataPreparation.getEvaluateDataTrue( alistuseractivityUserBean);
			 String arruser_evaluated[]=evaluated_caller_user_case3.split(",");
			 
			 
			 List<UserBean> valuesCase3 = new ArrayList<UserBean>(objCase3.values()); 
			 List<String[]> exotelcase3 = new ArrayList<String[]>();
			 List<String[]> calldeskcase3 = new ArrayList<String[]>();
			 List<String[]> gupshupcase3 = new ArrayList<String[]>();
			 exotelcase3.add(new String[] { "number","first_name","last_name","company_name","email","tag","custom_field" });
			 calldeskcase3.add(new String[] { "S.NO","DESK PHONE","CONTACT NAME"," NUMBER","EMAIL ID"," ADDRESS","STATUS","DATE/TIME"," Member"," Follow-up Date"," Comment","Existing customer","Status","Past comment" });
			 gupshupcase3.add(new String[] { "PHONE","%VAR1","%VAR2"});//case 2 %VAR2 will be there //interest
			 callserUserCount=0;
			 
			 for (UserBean oUserBean: valuesCase3) {
				if(oUserBean.getMobile().length()>1) {
					exotelcase3.add(new String[] { oUserBean.getMobile(),oUserBean.getName(),"","evaluated",oUserBean.getMailId(),"member","{ \"key:{ \"key1: values1 \"} \"}" });
					calldeskcase3.add(new String[] { "","",oUserBean.getName(),oUserBean.getMobile(),oUserBean.getMailId(),"","evaluated","",arruser_evaluated[callserUserCount],"",oUserBean.getInterest(),"","evaluated",""});//CASE 1 , CASE 2 notevaluated, CASE 3 evaluated 
					gupshupcase3.add(new String[] {"91"+ oUserBean.getMobile(),oUserBean.getName(),oUserBean.getInterest()});
				}
				callserUserCount++;
				if(callserUserCount>5) {
					callserUserCount=0;
				}
			}
			
			 WriteCSV.writeDataAtOnce(outputfolderpath+"exotel_EVALUATED.csv",exotelcase3);
			 WriteCSV.writeDataAtOnce(outputfolderpath+"calldesk_EVALUATED.csv",calldeskcase3);
			 WriteCSV.writeDataAtOnce(outputfolderpath+"gupchup_EVALUATED.csv",gupshupcase3);
	
			//CASE 3 BLOCK END
	}
	
	

}
