package com.target.casestudy.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.casestudy.entity.Price;
import com.target.casestudy.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getProduct() {
		ResponseEntity<Product> responseEntity = restTemplate.getForEntity("/product/15117729", Product.class);
		Product product = responseEntity.getBody();
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assert.assertEquals("Prod1", product.getName());
	}

	@Test
	public void updateProductPrice() {
		Product product = new Product();
		product.setId(16483589);
		Price price = new Price();
		price.setCurrencyCode("USD");
		price.setValue(12.45);
		product.setCurrencyPrice(price);

		restTemplate.put("/product/16483589", product);

		ResponseEntity<Product> productResponseEntity = restTemplate.getForEntity("/product/16483589", Product.class);

		Product updatedProduct = productResponseEntity.getBody();
		Assert.assertEquals(product.getCurrencyPrice().getValue(), updatedProduct.getCurrencyPrice().getValue());
	}
}
