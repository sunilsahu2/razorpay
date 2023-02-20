package com.recon.razorpay.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recon.razorpay.model.Razorpayorder;



public interface RazorpayOrderRepository extends MongoRepository<Razorpayorder, String> {

	 List<Razorpayorder> findByStatus(String status);
	
	
	
}
