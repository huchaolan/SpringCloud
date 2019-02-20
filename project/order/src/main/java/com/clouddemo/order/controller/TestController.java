package com.clouddemo.order.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.clouddemo.product.client.ProductClient;
import com.clouddemo.product.common.ProductInfoBean;

@RestController
@RequestMapping("/product")
public class TestController {

	@Autowired
	private LoadBalancerClient client;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProductClient prodcutClient;
	
	@GetMapping("/test")
	public List<ProductInfoBean>  test() throws Exception {
		List<ProductInfoBean>  productList = prodcutClient.getProductInfo(Arrays.asList("157875227953464068","164103465734242707"));
		return productList;
	}
}
