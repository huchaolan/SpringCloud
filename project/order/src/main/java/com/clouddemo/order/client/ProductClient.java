package com.clouddemo.order.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.clouddemo.order.client.bean.ProductInfo;

@FeignClient(name="PRODUCT")
public interface ProductClient {
	
	@GetMapping("/product/info/byid")
	List<ProductInfo> getProductInfo(List<String> productIdList);
	
	
}
