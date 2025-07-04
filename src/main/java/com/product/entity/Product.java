package com.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
	
	@Id
	private Integer productId;
	
	private String name;
	
	private String description;
	
	private Double price;
	
	private Integer quantityInStock;

}
