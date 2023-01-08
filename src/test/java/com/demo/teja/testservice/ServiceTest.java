package com.demo.teja.testservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.teja.demo.entity.Product;
import com.teja.demo.repository.ProductRepository;
import com.teja.demo.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	@InjectMocks
	ProductService prodSer;

	@Mock
	ProductRepository prodRes;

	@Test
	public void testProductsPriceGreater() {

		Product p1 = new Product(1, "mobile", 4, 330.00);
		Product p2 = new Product(2, "tv", 3, 530.00);
		Product p3 = new Product(3, "fridge", 3, 230.00);

		List<Product> newList = new ArrayList<>();

		newList.add(p1);
		newList.add(p2);
		newList.add(p3);

		List<Product> newList1 = newList.stream().filter(a -> a.price > 200).collect(Collectors.toList());

		Mockito.when(prodRes.findAll()).thenReturn(newList1);

		List<Product> list = prodSer.getProductsPriceGreater();

		assertEquals(3, list.size());

		}
}
