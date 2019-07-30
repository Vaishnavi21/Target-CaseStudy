package com.target.casestudy.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.casestudy.entity.Product;
import com.target.casestudy.repository.ProductRepository;
import com.target.casestudy.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public Optional<Product> getProductById(Integer id) {
		return productRepo.findById(id);
	}

	@Override
	public void updateProductPrice(Product product) {
		productRepo.updateProductPrice(product.getCurrencyPrice().getValue(), product.getId());
	}

}
