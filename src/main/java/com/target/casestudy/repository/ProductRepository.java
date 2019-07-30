package com.target.casestudy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.target.casestudy.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	public Optional<Product> findById(Integer id);

	@Modifying
	@Query(value = "update Product p set p.currencyPrice.value=:value where p.id=:productId")
	public void updateProductPrice(@Param("value") Double value, @Param("productId") Integer id);
}
