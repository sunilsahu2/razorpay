package com.recon.razorpay.resources;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.recon.razorpay.model.Item;
import com.recon.razorpay.model.RazorBean;
import com.recon.razorpay.model.Razorpayorder;
import com.recon.razorpay.model.RazorpayorderDAL;
import com.recon.razorpay.model.Summary;
import com.recon.razorpay.repository.RazorpayOrderRepository;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
@RestController
public class OrderResources {
 final RazorpayorderDAL objRazorpayorderDAL;
	final RazorpayOrderRepository objRazorpayOrderRepository;
	public OrderResources(RazorpayOrderRepository objRazorpayOrderRepository,RazorpayorderDAL objRazorpayorderDAL) {
		this.objRazorpayOrderRepository=objRazorpayOrderRepository;
		this.objRazorpayorderDAL=objRazorpayorderDAL;
		
	}

	
	 @GetMapping("/transactions44")
	public List<Razorpayorder> getAllUsers() {
		
		 
		 
		 
		/*Payment p=new Payment();

		p.setId("");
		p.setAmount("10.00");
		objPaymentRepository.save(p);
		
		*/
		System.out.println("dara");
		
	//	return objRazorpayOrderRepository.findAll(null);		
	  return objRazorpayOrderRepository.findByStatus("completed");
	}
	 
	 @GetMapping("/recon/{year}/{month}/{day}")
		public Summary getPullallsettletd(@PathVariable("year") String year,@PathVariable("month") String month,@PathVariable("day") String day) {
			
		 
		 Summary objSummary=new Summary();
				 
			 
		 OkHttpClient client = new OkHttpClient();

		 Request request = new Request.Builder()
		   .url("https://api.razorpay.com/v1/settlements/recon/combined?year="+year+"&month="+month+"&day="+day)
		   .get()
		   .addHeader("authorization", "Basic cnpwX2xpdmVfbXJ1dEVSalBtRXlYMUc6cUxlb29hMTJTMGhmdVpIdWhTUjcyeWJX")
		   .addHeader("cache-control", "no-cache")
		   .addHeader("postman-token", "f02f3cbe-0541-ea00-4d6b-0db43ddac466")
		   .build();

		 try {
			Response response = client.newCall(request).execute();
			//System.out.println("response1  "+response.body().string());
			
			String strResponse=response.body().string();
			System.out.println("response2  "+strResponse);
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			RazorBean objRazorBean= gson.fromJson(strResponse, RazorBean.class);
			
			System.out.println("objRazorBean total  "+objRazorBean.getCount());
			Item items[]=objRazorBean.getItems();
			System.out.println("objRazorBean total  "+items.length);
		
			 
			 float sumPayment=0L;
			 float sumCredit=0L;
			 float sumFee=0L;
			 float sumRefund=0L;
			 float totalsumonDemandSelttle=0L;
			 float sumCreditDemandSelttle=0L;
			 float sumFeeDemandSelttle=0L;
			 int totalPaymentcount=0;
			 int totalRefundcount=0;
			 int totalDemandSettlementcount=0;
			 
			 
			for(Item objitm:items) {
		if("payment".equalsIgnoreCase(objitm.getType())) {
			
		
			totalPaymentcount=totalPaymentcount+1;
			
	List<Razorpayorder> alist=objRazorpayorderDAL.getMatchOrder(objitm.getOrder_id());
			
			for(Razorpayorder objRazorpayorder:alist) {
				
			//	System.out.println("event complete json "+objRazorpayorder.toString());
				
			if(objRazorpayorder.getSuccess()!=null&&objRazorpayorder.getSuccess().getEvent()!=null&&objRazorpayorder.getSuccess().getEvent().equalsIgnoreCase("payment.captured")) {
			sumPayment=sumPayment+Float.valueOf(objitm.getAmount()/100f);
			sumCredit=sumCredit+Float.valueOf(objitm.getCredit()/100f);
			sumFee=sumFee+Float.valueOf(objitm.getFee()/100f);
			
			
			
			
			//if(objRazorpayorder.getRazorPayOrderId().equals("order_JDFtEWtZzjuIhI")){
			//	System.out.println("going for update ");
				objRazorpayorderDAL.updateOrder(objRazorpayorder,objitm);
				}else {
			System.out.println("TXN Not success in DB "+objRazorpayorder.toString());
				System.out.println("TXN Not success in DB "+objitm.toString());
			}

			}
		
			
		}
		
		
		else if("refund".equalsIgnoreCase(objitm.getType())) {
			totalRefundcount=totalRefundcount+1;
			
			
			
			//objRazorpayorder=objRazorpayorderDAL.getMatchOrder(objitm.getOrder_id());
			sumRefund=sumRefund+Float.valueOf(objitm.getDebit()/100f);
			
				//objRazorpayorder.setReconstatus("yes");

				//if(objRazorpayorder.getRazorPayOrderId().equals("order_JDFtEWtZzjuIhI")){
			//	System.out.println("going for update ");
				//objRazorpayorderDAL.updateOrder(objRazorpayorder,objitm);
			
			
		}else if ("settlement.ondemand".equalsIgnoreCase(objitm.getType())){
			totalDemandSettlementcount=totalDemandSettlementcount+1;
			totalsumonDemandSelttle=totalsumonDemandSelttle+Float.valueOf(objitm.getAmount()/100f);
			sumCreditDemandSelttle=sumCreditDemandSelttle+Float.valueOf(objitm.getCredit()/100f);
			sumFeeDemandSelttle=sumFeeDemandSelttle+Float.valueOf(objitm.getFee()/100f);
			
			
		}
		

		
			}
			
			objSummary.setPaymentAmount(sumPayment);
			objSummary.setPaymentCredit(sumCredit);
			objSummary.setPgcharge(sumFee);
			objSummary.setPaymentCount(totalPaymentcount);
			objSummary.setSettlementDate(year+"-"+month+"-"+day);
			objSummary.setRecondateandtime(new Date().toString());
			objSummary.setRefundCount(totalRefundcount);
			objSummary.setRefundAmount(sumRefund);
			objSummary.setSumCreditDemandSelttle(sumCreditDemandSelttle);
			objSummary.setSumFeeDemandSelttle(sumFeeDemandSelttle);
			objSummary.setTotalDemandSettlementcount(totalDemandSettlementcount);
			objSummary.setTotalsumonDemandSelttle(totalsumonDemandSelttle);
			System.out.println(" final Result "+objSummary);

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//Razorpayorder objRazorpayorder=new Razorpayorder();
		 
		 
		//objRazorpayorder=objRazorpayorderDAL.getMatchOrder("OR-1I7H5R1635562197071");
	
		  return objSummary;//objRazorpayOrderRepository.findByStatus("completed");
		}
	 
	 
	 
	
}
