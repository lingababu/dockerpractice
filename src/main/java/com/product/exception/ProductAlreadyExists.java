package com.product.exception;


public class ProductAlreadyExists extends RuntimeException {
	
	public ProductAlreadyExists(String name) {
		
		super(name);
	}

}
