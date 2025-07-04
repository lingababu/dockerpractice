package com.product.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductDto;
import com.product.entity.Product;
import com.product.exception.ProductAlreadyExists;
import com.product.exception.ProductNotExists;
import com.product.exception.ProductsListEmpty;
import com.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Product", description ="Products REST API")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Operation(summary="Add Products", description="By using this url we can add products.")
	@PostMapping(value = "/add")
	public ResponseEntity<ProductDto> addProducts(@RequestBody ProductDto productDto) {

		boolean flag = productService.saveProducts(productDto);

		if (flag) {

			return ResponseEntity.ok(productDto);

		} else {

			throw new ProductAlreadyExists("Error: Product Id: " + productDto.getProductId() + " already exist");
		}

	}

	@GetMapping(value = "/productsList")
	public ResponseEntity<List<ProductDto>> getAllProducts() {

		List<ProductDto> productsList = productService.retriveAllProducts();

		if (!productsList.isEmpty()) {

			return new ResponseEntity<List<ProductDto>>(productsList, HttpStatus.OK);

		}

		throw new ProductsListEmpty("Error: No Products data.");

	}

	@GetMapping("/getProductBy/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id) {

		ProductDto product = productService.getProductsById(id);

		if (product != null) {

			return new ResponseEntity<ProductDto>(product, HttpStatus.OK);
		} else {
			throw new ProductNotExists("Error: Product with id: " + id + " not exists.");
		}
	}

	@PutMapping("/updateProductBy/{id}")
	public ResponseEntity<Product> updateProductById(@RequestBody Product product, @PathVariable Integer id) {

	    product.setProductId(id);

		Product data = productService.updateProductById(product);

		if (data != null) {

			return new ResponseEntity<Product>(data, HttpStatus.OK);
		} else {

			throw new ProductNotExists("Error: Product with id: " + id + " not exists.");
		}
	}
	
	@DeleteMapping("/deleteBy/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
		
		boolean flag = productService.deleteById(id);
		
		if(flag) {
			return ResponseEntity.ok("Product with id: "+ id+" has been deleted.");
		}else {
			
			throw new ProductNotExists("Error: Product with id: "+ id +" not exists.");
		}
	}
}
