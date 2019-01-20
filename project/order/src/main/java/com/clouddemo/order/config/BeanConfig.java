package com.clouddemo.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeanConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		RestTemplate rest = new RestTemplate();
		return rest;
	}
}
