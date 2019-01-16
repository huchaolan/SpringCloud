package com.clouddemo.product.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.clouddemo.product.dataobject.ProductCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

	@Autowired
	private ProductCategoryRepository tester;
	
	@Test
	public void testFindByCategoryTypeIn() {
		List<ProductCategory> result  =tester.findByCategoryTypeIn(Arrays.asList(11,22));
		Assert.assertTrue(result.size()>0);
	}

}
