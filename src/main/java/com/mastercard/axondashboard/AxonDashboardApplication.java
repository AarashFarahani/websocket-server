package com.mastercard.axondashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AxonDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxonDashboardApplication.class, args);
	}

}
