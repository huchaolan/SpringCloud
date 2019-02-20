package com.clouddemo.product.service;

import java.util.List;

import com.clouddemo.product.common.ProductDTO;
import com.clouddemo.product.common.ProductInfoBean;
import com.clouddemo.product.dataobject.ProductInfo;

public interface ProductInfoService {

	public List<ProductInfo> findAllUp();

	public List<ProductInfoBean> getProductInfo(List<String> productidList);

	public String decreaseProductStock(List<ProductDTO> productDTOList);
}
