package com.recon.razorpay;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.recon.razorpay.repository.RazorpayOrderRepository;


@SpringBootApplication
@EnableMongoRepositories
public class RazorpayApplication {
	@Autowired
	static RazorpayOrderRepository objRazorpayOrderRepository;
	public static void main(String[] args) throws IOException {
	//SpringApplication.run(RazorpayApplication.class, args);
		alert.Main objMain=new alert.Main();
		
		objMain.main(args);
		
	}

}
