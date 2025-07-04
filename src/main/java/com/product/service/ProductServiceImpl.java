package com.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.ProductDto;
import com.product.entity.Product;
import com.product.mapper.ProductMapper;
import com.product.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public boolean saveProducts(ProductDto productDto) {

		Optional<Product> isProductExist = productRepo.findById(productDto.getProductId());

		if (isProductExist.isPresent()) {

			return false;
		}

		Product product = ProductMapper.convertToEntity(productDto);

		productRepo.save(product);

		return true;
	}

	@Override
	public List<ProductDto> retriveAllProducts() {

		List<Product> productList = productRepo.findAll();

		if (productList.isEmpty()) {
			return new ArrayList<>();
		}

		return ProductMapper.convertToDtoList(productList);

	}

	@Override
	public ProductDto getProductsById(Integer id) {

		Optional<Product> product = productRepo.findById(id);

		if (product.isPresent()) {

			Product productDetails = product.get();

			ProductDto data = ProductMapper.convertToDto(productDetails);

			return data;
		}

		return null;
	}

	@Override
	public Product updateProductById(Product product) {

		Optional<Product> isProductExist = productRepo.findById(product.getProductId());

		if (isProductExist.isPresent()) {

			Product needToUpdate = isProductExist.get();
			needToUpdate.setName(product.getName());
			needToUpdate.setDescription(product.getDescription());
			needToUpdate.setPrice(product.getPrice());
			needToUpdate.setQuantityInStock(product.getQuantityInStock());

			return productRepo.save(needToUpdate);

		}

		return null;
	}

	@Override
	public boolean deleteById(Integer id) {

		Optional<Product> data = productRepo.findById(id);

		if (data.isPresent()) {

			productRepo.deleteById(id);

			return true;
		}

		return false;
	}

}
