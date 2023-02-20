package com.recon.razorpay.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
@Repository
public class RazorpayorderImple implements RazorpayorderDAL{
	private final MongoTemplate mongoTemplate;
	 @Autowired
	    public RazorpayorderImple(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }
	
	@Override
	public List<Razorpayorder> getMatchOrder(String orderid) {
		Query query = new Query();
		   query.addCriteria(Criteria.where("razorPayOrderId").is(orderid));
		  
		   
		   return mongoTemplate.find(query, Razorpayorder.class);
		
	}

	@Override
	public Razorpayorder updateOneRecord(Razorpayorder order) { 
		mongoTemplate.save(order);
		return order;
	}

	@Override
	public void updateOrder(Razorpayorder order,Item objitm) {
	
		
		
		Query query = new Query();
		   query.addCriteria(Criteria.where("orderId").is(order.getOrderId()));
		//   query.addCriteria(Criteria.where("orderId").is(objitm.getOrder_receipt()));
		   
		   
		   
		   Update update = new Update().set("settled_status", "settled");
		   
		   float r;
		   r=objitm.getCredit()/100f;
		   
		   
		   update.set("settled_date", objitm.getSettled_at());
		   update.set("settled_amount",Float.valueOf(r));
		   update.set("settled_id", objitm.getSettlement_id());
		   update.set("settled_utr", objitm.getSettlement_utr());
		   update.set("pg_charge", Float.valueOf(objitm.getFee()/100f));
		   
		   
		   mongoTemplate.findAndModify(query, update, Razorpayorder.class);
		
		
	}




	

}
