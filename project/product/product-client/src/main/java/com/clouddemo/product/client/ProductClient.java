package com.clouddemo.order.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.clouddemo.order.client.bean.ProductInfo;
import com.clouddemo.order.dto.ProductDTO;

@FeignClient(name="PRODUCT")//PRODUCT是产品服务注册名称
public interface ProductClient {
	
	@GetMapping("/product/info/byid")//这里要写url全路径不是method方法下的路径
	List<ProductInfo> getProductInfo(List<String> productIdList);
	
	@PostMapping("/product/stock/byid")
	String decreaseProductStock(List<ProductDTO> productDTOList);
}
