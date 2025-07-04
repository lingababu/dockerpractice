package com.product.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.product.dto.ProductDto;
import com.product.entity.Product;

public class ProductMapper {
	
	private static final ModelMapper mapper = new ModelMapper();
	
	public static ProductDto convertToDto(Product product) {
		
		return mapper.map(product, ProductDto.class);
	}
	
	public static Product convertToEntity(ProductDto productDto) {
		
		return mapper.map(productDto, Product.class);
	}
	
	public static List<ProductDto> convertToDtoList(List<Product> products){
		
		return products.stream().map(ProductMapper :: convertToDto).collect(Collectors.toList());
	}

}
