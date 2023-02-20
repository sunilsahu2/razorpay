package alert.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.opencsv.CSVReader;

public class ReadCSV {

	public static void main(String[] args) throws FileNotFoundException {
		 String fname="D:\\funngro\\recon\\date12jan\\user (39).csv";
		// String fname="D:\\funngro\\recon\\Funngro (98).csv";
		 ArrayList<String> all= ReadCSV.getArrayList(fname);
		 System.out.println(all);
		 
	}
	public static HashMap <String,UserBean> extractDataFromUser(String fileName) throws IOException{
		HashMap <String,UserBean> alistresult=new HashMap <String,UserBean>();
		UserBean objUserBean=null;
		
		CSVReader reader = new CSVReader(new FileReader(fileName), ',');
		String[] record = null;
		while ((record = reader.readNext()) != null) {
			objUserBean=new UserBean();
			objUserBean.setMailId(record[3]);
			objUserBean.setMobile(record[2]);
			objUserBean.setName(record[1]);
			objUserBean.setRole(record[5]);
	
			alistresult.put(objUserBean.getMobile(),objUserBean);
		
		}
		
		reader.close();
		
	
		return alistresult;
	}
	
	
	
	public static HashMap <String,UserBean>  extractDataFromUserActivity(String fileName) throws IOException{
		HashMap <String,UserBean> alistresult=new HashMap <String,UserBean>();
		UserBean objUserBean=null;
	
		@SuppressWarnings("deprecation")
		CSVReader reader = new CSVReader(new FileReader(fileName), ',');
		String[] record = null;
		while ((record = reader.readNext()) != null) {
			objUserBean=new UserBean();
			objUserBean.setMailId(record[5]);
			objUserBean.setMobile(record[4]);
			objUserBean.setName(record[2]);
			objUserBean.setEvaluation(record[15]);
			objUserBean.setInterest(record[8].replaceAll("[,_\\[\\]\"]", " "));
			//alistresult.put(objUserBean.getMobile(),null);
			alistresult.put(objUserBean.getMobile(),objUserBean);
		}
		
	
		return alistresult;
	}

	
	
	public static ArrayList<String> getArrayList(String fileName) throws FileNotFoundException{
		
		
		
		ArrayList<String> al=new ArrayList<String>();
		Scanner sc = new Scanner(new File(fileName));  
		sc.useDelimiter("\\n");   //sets the delimiter pattern  
		while (sc.hasNext())  //returns a boolean value  
		{  
		al.add(sc.next());          
		}   
		sc.close();  //closes the scanner  
		
		return al;
		} 
	
	public static Properties getReadProperties(String spath){
		 Properties prop = new Properties();
		 try (InputStream input = new FileInputStream(spath)) {
            prop.load(input);

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		 return prop;

	}

	
	
}
	
	


