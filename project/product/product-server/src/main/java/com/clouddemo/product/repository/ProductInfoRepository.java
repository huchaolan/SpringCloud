package com.clouddemo.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clouddemo.product.dataobject.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{

	public List<ProductInfo> findByProductStatus(Integer productStatus);
	
	public List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
