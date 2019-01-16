package com.clouddemo.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clouddemo.product.dataobject.ProductCategory;
import com.clouddemo.product.dataobject.ProductInfo;
import com.clouddemo.product.service.ProductCategoryService;
import com.clouddemo.product.service.ProductInfoService;
import com.clouddemo.product.util.RestResultUtil;
import com.clouddemo.product.vo.ProductCategoryVO;
import com.clouddemo.product.vo.ProductInfoVO;
import com.clouddemo.product.vo.RestResult;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductInfoService productInfoService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public RestResult<List<ProductCategoryVO>> listProduct(){
		List<ProductInfo> productList = productInfoService.findAllUp();
		List<Integer> categoryList = productList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
		List<ProductCategory>  productCategoryList = productCategoryService.findByCategoryTypeIn(categoryList);
		List<ProductCategoryVO> result = new ArrayList<>();
		for(ProductCategory category:productCategoryList) {
			ProductCategoryVO categoryVo = new ProductCategoryVO();
			categoryVo.setCategoryName(category.getCategoryName());
			categoryVo.setCategoryType(category.getCategoryType());
			List<ProductInfoVO> foods = new ArrayList<>();
			for(ProductInfo productInfo:productList) {
				if(productInfo.getCategoryType().equals(categoryVo.getCategoryType())) {
					ProductInfoVO productInfoVO = new ProductInfoVO();
					BeanUtils.copyProperties(productInfo, productInfoVO);
					foods.add(productInfoVO);
				}
			}
			categoryVo.setProdcutInfoList(foods);
			result.add(categoryVo);
		}
		return RestResultUtil.success(result);
	}
}
