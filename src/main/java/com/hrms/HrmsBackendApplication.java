package com.hrms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hrms_db")
public class HrmsBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(HrmsBackendApplication.class, args);
	}
}
