package com.recon.razorpay.model;

import java.util.List;

public interface RazorpayorderDAL {
	
	public List<Razorpayorder> getMatchOrder(String orderid);
	public Razorpayorder updateOneRecord(Razorpayorder order);
	
	
	

	public void updateOrder(Razorpayorder order,Item objitm); 

}
