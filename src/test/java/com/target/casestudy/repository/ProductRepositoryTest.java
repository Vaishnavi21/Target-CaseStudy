package com.target.casestudy.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.casestudy.entity.Product;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testGetProductById() {
		Optional<Product> product = productRepository.findById(15117729);
		Assert.assertTrue("Product ID not Found", product.isPresent());
		Assert.assertEquals("Comparison of product Details Failed!", null, product.get());
	}

	public void testGetProductByInvalidId() {
		Optional<Product> product = productRepository.findById(8956);
		Assert.assertFalse("Product ID not Found", product.isPresent());
	}
}
