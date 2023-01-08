package com.teja.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teja.demo.entity.Product;
import com.teja.demo.repository.ProductRepository;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	public Optional<Product> getProductById(int id) {
		Optional<Product>  product = repository.findById(id);
		LOGGER.info("REPO LAYER");
return product;
	}

	public Product getProductByName(String name) {
		return repository.findByName(name);
	}

	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed" + id;
	}

	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);

		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}

	public Product getProductByNameAndPrice(String name, Double price) {
		// TODO Auto-generated method stub
		return repository.findByNameAndPrice(name, price);

	}

	public Product getProductsByTop() {
		// TODO Auto-generated method stub
		return repository.findTopByOrderByPriceDesc();
	}

	public List<Product> getProductsPriceGreater() {
		// TODO Auto-generated method stub
		return repository.findAll().stream().filter(a -> a.price > 200).collect(Collectors.toList());
	}
}
