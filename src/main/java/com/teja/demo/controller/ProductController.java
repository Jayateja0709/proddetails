package com.teja.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teja.demo.entity.Product;
import com.teja.demo.service.ProductService;

@RestController
public class ProductController {

	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);
	@Autowired
	private ProductService service;

	@PostMapping(path = "/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	/*
	 * @PostMapping(value = "/addProducts") public List<Product>
	 * addProducts(@RequestBody List<Product> products){
	 * 
	 * return service.saveProducts(products); }
	 */

	@GetMapping(value = "/products")
	public List<Product> findProducts() {
		return service.getProducts();
	}

	@GetMapping("/product/{id}")
	public Optional<Product> findProductById(@PathVariable int id) {

		Optional<Product> product = service.getProductById(id);
		LOGGER.info("request going to service layer");
		System.out.println("going to service");
		return product;
		// dfdsfkds

	}

	@GetMapping("/products/{name}")
	public Product findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}

	@GetMapping("/productsByNameAndPrice/{name}/{price}")
	public Product findProductByNameAndPrice(@PathVariable String name, @PathVariable Double price) {
		return service.getProductByNameAndPrice(name, price);
	}

	@GetMapping("/productsByTop")
	public Product findProductsByTop() {
		return service.getProductsByTop();
	}

	@GetMapping("/productsByNameAndPrice")
	public Product findProductByNameAndPriceR(@RequestParam String name, @RequestParam Double price) {
		return service.getProductByNameAndPrice(name, price);
	}

	@GetMapping("/productsByNameAndPrice1")
	public Product findProductByNameAndPricep(@RequestParam String name, @RequestParam Double price) {
		return service.getProductByNameAndPrice(name, price);
	}

	@GetMapping("/productsGreaterThanPrice")
	public List<Product> findProductsByPriceGreater() {
		return service.getProductsPriceGreater();
	}

	@PutMapping("/update/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
		return service.updateProduct(product, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
}
