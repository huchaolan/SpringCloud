package com.clouddemo.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.clouddemo.product.client.ProductClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.clouddemo.product.client")
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}

