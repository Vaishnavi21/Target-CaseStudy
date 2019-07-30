package com.target.casestudy.service;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.target.casestudy.entity.Product;

public interface ProductService {
	/**
	 * Method to get Product details based on ID provided.
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Product> getProductById(@NotNull Integer id);

	/**
	 * Method to update the value variable of Product.currentPrice object
	 * 
	 * @param product
	 */
	public void updateProductPrice(@NonNull Product product);
}
