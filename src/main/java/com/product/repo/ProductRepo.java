package com.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.product.dto.ProductDto;
import com.product.entity.Product;

import jakarta.transaction.Transactional;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
//	@Query(value ="update Product set name=?,description=?,price=?,quantity_in_stock=?", nativeQuery = true)
//	@Modifying
//	@Transactional
//	public ProductDto updateProductById(ProductDto productDto, Integer id);

}
