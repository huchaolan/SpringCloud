package com.clouddemo.product.service.impl;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clouddemo.product.dataobject.ProductInfo;
import com.clouddemo.product.dto.ProductDTO;
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
    public List<ProductInfo> getProductInfo(List<String> productidList) {
	    return productInfoRepository.findByProductIdIn(productidList);
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
