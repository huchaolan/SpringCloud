package com.clouddemo.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clouddemo.product.dataobject.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{
	
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
