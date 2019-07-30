package com.target.casestudy.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.target.casestudy.entity.Product;
import com.target.casestudy.service.ExternalProductService;

@RestController
public class ExternalMerchantController {
	private Random rand = new Random(999);

	@Autowired
	ExternalProductService mockMerchantCallService;

	/**
	 * Mocking External Merchant API that returns Product details
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/mock/product/{id}")
	public Product mockAPIToReturnProductName(@PathVariable Integer id) {
		Product product = new Product();
		product.setId(id);
		product.setName("mock-" + rand.nextLong());

		return product;
	}

	/**
	 * TEST - API to get product information from Merchant API
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/external/product/{id}")
	public Product fetchProductByIdFromMerchant(@PathVariable Integer id) {
		return mockMerchantCallService.fetchProductByIdFromMerchant(id);
	}
}
