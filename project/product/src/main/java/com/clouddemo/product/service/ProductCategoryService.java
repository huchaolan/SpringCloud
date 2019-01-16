package com.clouddemo.product.service;

import java.util.List;

import com.clouddemo.product.dataobject.ProductCategory;

public interface ProductCategoryService {

	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
