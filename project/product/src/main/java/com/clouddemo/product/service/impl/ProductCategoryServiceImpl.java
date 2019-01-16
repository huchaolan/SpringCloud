package com.clouddemo.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouddemo.product.dataobject.ProductCategory;
import com.clouddemo.product.repository.ProductCategoryRepository;
import com.clouddemo.product.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
	    return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
	
}
