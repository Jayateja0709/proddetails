package com.teja.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teja.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

	Product findByNameAndPrice(String name, Double price);

	Product findTopByOrderByPriceDesc();

}
