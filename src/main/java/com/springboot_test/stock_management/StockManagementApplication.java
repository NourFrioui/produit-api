package com.springboot_test.stock_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot_test.stock_management")
public class StockManagementApplication {

	public static void main(final String[] args) {
		SpringApplication.run(StockManagementApplication.class, args);
	}

}
