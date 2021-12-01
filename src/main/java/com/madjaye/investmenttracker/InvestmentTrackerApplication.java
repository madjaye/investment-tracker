package com.madjaye.investmenttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class InvestmentTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvestmentTrackerApplication.class, args);
    }


}
