package com.clouddemo.order.controller;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class TestController {

	@Autowired
	private LoadBalancerClient client;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/test")
	public String test() throws Exception {
	/*	RestTemplate rt = new RestTemplate();
		String msg = rt.getForObject(new URI("http://127.0.0.1:8081/product/getProductInfo"), String.class);*/
		
/*		ServiceInstance  serviceInstance = client.choose("PRODUCT");
		Map<String, String> map = serviceInstance.getMetadata();
		System.out.println(map);
		String url = String.format("http://%s:%s/product/getProductInfo",serviceInstance.getHost(),serviceInstance.getPort());
		System.out.println("==============>" + url);
		RestTemplate rt = new RestTemplate();
		String msg = rt.getForObject(new URI(url), String.class);*/
		
		String msg = restTemplate.getForObject(new URI("http://PRODUCT/product/getProductInfo"), String.class);
		return msg;
	}
}
