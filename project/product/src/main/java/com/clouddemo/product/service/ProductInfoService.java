package com.clouddemo.product.service;

import java.util.List;

import com.clouddemo.product.dataobject.ProductInfo;
import com.clouddemo.product.dto.ProductDTO;

public interface ProductInfoService {

	public List<ProductInfo> findAllUp();

	public List<ProductInfo> getProductInfo(List<String> productidList);

	public String decreaseProductStock(List<ProductDTO> productDTOList);
}
