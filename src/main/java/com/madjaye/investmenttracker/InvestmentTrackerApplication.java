package com.madjaye.investmenttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@RestController
public class InvestmentTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentTrackerApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hello Investment Tracking World";
	}

}
