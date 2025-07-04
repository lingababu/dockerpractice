package com.product.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.product.dto.ProductDto;
import com.product.exception.ProductAlreadyExists;
import com.product.exception.ProductNotExists;
import com.product.exception.ProductsListEmpty;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ProductAlreadyExists.class)
	public ResponseEntity<String> handelProductAlreadyExistsException(ProductAlreadyExists ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(ProductsListEmpty.class)
	public ResponseEntity<String> handelProductsListEmpty(ProductsListEmpty ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProductNotExists.class)
	public ResponseEntity<String> handelProductNotExists(ProductNotExists ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}
}
