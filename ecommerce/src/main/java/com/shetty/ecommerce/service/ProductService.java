package com.shetty.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shetty.ecommerce.Entities.Product;
import com.shetty.ecommerce.dao.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productReposotory;

	public List<Product> getAllProducts() {
		logger.info("📦 Fetching all products from database");
		Iterable<Product> iterable= productReposotory.findAll();
	    List<Product> list = (List<Product>)iterable;
	    return list;
	}

	public Product getProductById(Long id) {
		logger.info("🔍 Fetching product with ID: {}", id);
		Optional<Product> optional=productReposotory.findById(id);
		return optional.orElse(null);
	}

	public Product addProduct(Product product) {
		Product p = productReposotory.save(product);
		logger.info("✅ Added new product: {}", p.getName());
		return p;
	}
	
	public Product updateProduct(Long id, Product product) {
		product.setId(id);
		Product updatedProduct = productReposotory.save(product);
		logger.info("♻️ Updated product with ID: {}", id);
		return updatedProduct;
	}

	public void deleteProduct(Long id) {
		productReposotory.deleteById(id);
		logger.warn("🗑️ Deleted product with ID: {}", id);
	}
}
