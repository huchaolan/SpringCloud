package com.clouddemo.product.service;

import java.util.List;

import com.clouddemo.product.dataobject.ProductInfo;

public interface ProductInfoService {

	public List<ProductInfo> findAllUp();

	public List<ProductInfo> getProductInfo(List<String> productidList);
}
