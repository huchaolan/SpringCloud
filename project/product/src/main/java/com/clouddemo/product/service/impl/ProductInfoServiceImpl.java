package com.clouddemo.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouddemo.product.dataobject.ProductInfo;
import com.clouddemo.product.enums.ProductType;
import com.clouddemo.product.repository.ProductInfoRepository;
import com.clouddemo.product.service.ProductInfoService;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	@Override
	public List<ProductInfo> findAllUp() {
		return productInfoRepository.findByProductStatus(ProductType.UP.getStatus());
	}

	@Override
    public List<ProductInfo> getProductInfo(List<String> productidList) {
	    return productInfoRepository.findByProductIdIn(productidList);
    }

}
