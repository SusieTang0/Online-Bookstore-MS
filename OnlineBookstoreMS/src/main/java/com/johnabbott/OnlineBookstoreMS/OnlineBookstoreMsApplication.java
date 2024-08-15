package com.johnabbott.OnlineBookstoreMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.johnabbott.OnlineBookstoreMS.service.PurchaseService;
import com.johnabbott.OnlineBookstoreMS.service.PurchaseServiceImpl;

@SpringBootApplication
public class OnlineBookstoreMsApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(OnlineBookstoreMsApplication.class, args);
	}

}
