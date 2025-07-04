package com.product.service;

import java.util.List;

import com.product.dto.ProductDto;
import com.product.entity.Product;

public interface ProductService {
	
	public boolean saveProducts(ProductDto product);
	
	public List<ProductDto> retriveAllProducts();
	
	public ProductDto getProductsById(Integer id);
	
	public Product updateProductById(Product product);
	
	public boolean deleteById(Integer id);

}
