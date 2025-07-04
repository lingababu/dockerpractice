package com.product.dto;

import lombok.Data;

@Data
public class ProductDto {
	
	private Integer productId;
	private String name;
	private String description;
	private Double price;
	private Integer quantityInStock;

}
