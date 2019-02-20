package com.clouddemo.product.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clouddemo.product.common.ProductDTO;
import com.clouddemo.product.common.ProductInfoBean;
import com.clouddemo.product.dataobject.ProductInfo;
import com.clouddemo.product.enums.ProductError;
import com.clouddemo.product.enums.ProductType;
import com.clouddemo.product.exception.ProductException;
import com.clouddemo.product.repository.ProductInfoRepository;
import com.clouddemo.product.service.ProductInfoService;

@Service
@Slf4j
public class ProductInfoServiceImpl implements ProductInfoService {

	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	@Override
	public List<ProductInfo> findAllUp() {
		return productInfoRepository.findByProductStatus(ProductType.UP.getStatus());
	}

	@Override
    public List<ProductInfoBean> getProductInfo(List<String> productidList) {
		List<ProductInfo> productList = productInfoRepository.findByProductIdIn(productidList);
		return productList.stream().map(e->{
					ProductInfoBean bean = new ProductInfoBean(); 
					BeanUtils.copyProperties(e, bean); 
					return bean;
				}).collect(Collectors.toList());
    }

	@Override
	@Transactional
    public String decreaseProductStock(List<ProductDTO> productDTOList) {
	    for(ProductDTO pdto:productDTOList) {
	    	String productId = pdto.getProductId();
	    	Optional<ProductInfo> op = productInfoRepository.findById(productId);
	    	if(!op.isPresent()){
	    		throw new ProductException(ProductError.PRODUCT_NOT_EXIST);
	    	}
	    	ProductInfo pinfo = op.get();
	    	int orgStock = pinfo.getProductStock();
	    	int newStock = orgStock - pdto.getProductQuantity();
	    	if(newStock<0){
	    		throw new ProductException(ProductError.INVENTORY_SHORTAGE);
	    	}
	    	log.error("[orgStock]"+orgStock+"|newStock:"+newStock);
	    	pinfo.setProductStock(newStock);
	    	productInfoRepository.save(pinfo);
	    }
	    return "success";
    }
	
	

}
