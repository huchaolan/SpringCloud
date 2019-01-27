package com.clouddemo.product.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.clouddemo.product.dataobject.ProductInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
	
	@Autowired
	private ProductInfoRepository test = null;

	@Test
	public void testFindProductInfoByStatus() {
		List<ProductInfo> result = test.findByProductStatus(0);
		Assert.assertTrue(result.size()>0);
	}
	
	@Test
	public void testFindByProductIdIn() {
		List<ProductInfo> result = test.findByProductIdIn(Arrays.asList("157875196366160022","157875227953464068"));
		Assert.assertTrue(result.size()>0);
	}

}
