package com.recon.razorpay.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.recon.razorpay.repository.RazorpayOrderRepository;


//@SpringBootApplication
//@EnableMongoRepositories
public class RazorpayApplication {
	@Autowired
	static RazorpayOrderRepository objRazorpayOrderRepository;
	public static void main(String[] args) {
		SpringApplication.run(RazorpayApplication.class, args);
		

		
	}

}
