package com.target.casestudy.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.target.casestudy.entity.Product;
import com.target.casestudy.service.ExternalProductService;

@Service
public class ExternalProductServiceImpl implements ExternalProductService {

	private RestTemplate template = new RestTemplate();

	@Value("${merchant.product.service.url}")
	private String productServiceURL;

	/**
	 * Function to make Network call to Merchant to fetch product details.
	 */
	@Override
	public Product fetchProductByIdFromMerchant(Integer id) {
		ResponseEntity<Product> responseEntity = template.getForEntity(productServiceURL + id, Product.class);
		return HttpStatus.OK.equals(responseEntity.getStatusCode()) ? responseEntity.getBody() : null;
	}

}
