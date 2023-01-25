package com.teja.demo.testcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.teja.demo.controller.ProductController;
import com.teja.demo.entity.Product;
import com.teja.demo.service.ProductService;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ControllerTest {

	@InjectMocks
	ProductController controller;

	@Mock
	ProductService service;

	@Test
	public void testAddProduct() {

		Product product = new Product(1, "teja", 2, 23.45);

		Mockito.when(service.saveProduct(product)).thenReturn(product);
		controller.addProduct(product);
		// when(externalSystemProxy.connectionAvailable(any(String.class))).thenThrow(new
		// IOException());

		assertEquals(23.45, product.getPrice());

		// assertThat(product1.getPrice()).isEqualTo(23.45);
		// assertEquals(product1.getPrice()).isEqualTo(23.45);
		// assert(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
	}
}
