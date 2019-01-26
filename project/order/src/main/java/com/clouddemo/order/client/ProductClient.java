package com.clouddemo.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="PRODUCT")
public interface ProductClient {
	
	@GetMapping("/product/getProductInfo")
	String getProductInfo();
}
