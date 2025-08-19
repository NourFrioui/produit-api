package com.springboot_test.stock_management.controller;

import com.springboot_test.stock_management.model.dto.ProductDto;
import com.springboot_test.stock_management.model.entity.Product;
import com.springboot_test.stock_management.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
	@Autowired
	private final ProductService productService;

	@GetMapping("/hello")
	public static String hello() {
		return "Hello from TestController!";
	}

	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return this.productService.getAllProducts();

	}


	@PostMapping
	public Product createProduct(@RequestBody final ProductDto request) {
		return this.productService.createProduct(request);
	}


	@GetMapping("{id}")
	public Product getProductById(@PathVariable final long id) {
		return this.productService.getProductById(id);

	}

	@DeleteMapping("{id}")
	public String deleteProduct(@PathVariable final long id) {
		return this.productService.deleteProduct(id);

	}

	@PatchMapping("{id}")
	public Product updateProduct(@PathVariable final long id, @RequestBody final Product product) {
		return this.productService.updateProduct(id, product);
	}

}
