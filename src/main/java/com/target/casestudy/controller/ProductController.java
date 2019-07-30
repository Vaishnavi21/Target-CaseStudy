package com.target.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.casestudy.entity.Product;
import com.target.casestudy.service.ProductService;

/**
 * Product Controller to retrieve and manage Product information.
 * 
 * @author vaish
 *
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Method to fetch Product based on the ID provided.
	 * 
	 * @param id
	 *            - Product ID of the product to be fetched
	 * @return Returns the product information based on the ID provided
	 */
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable("id") Integer id) {
		return productService.getProductById(id).orElse(new Product());
	}

	/**
	 * Method to update the price value of the product
	 * 
	 * @param product
	 *            : Product details containing the price to update.
	 */
	@PutMapping("/product/{id}")
	public void updateProductPrice(@RequestBody Product product) {
		productService.updateProductPrice(product);
	}
}
