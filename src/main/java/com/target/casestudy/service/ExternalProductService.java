package com.target.casestudy.service;

import org.springframework.lang.NonNull;

import com.target.casestudy.entity.Product;

public interface ExternalProductService {

	/**
	 * Method to mock call to external service to fetch Product details from
	 * merchant API
	 * 
	 * @param id
	 * @return
	 */
	public Product fetchProductByIdFromMerchant(@NonNull Integer id);
}
