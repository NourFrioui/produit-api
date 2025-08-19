package com.springboot_test.stock_management.controller;

import com.springboot_test.stock_management.model.entity.Category;
import com.springboot_test.stock_management.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;


	@GetMapping("/hello")
	public static String sayHell() {
		return "Hello";
	}


	@GetMapping("/all")
	public List<Category> getAllCategories() {
		return this.categoryService.getAllCategories();

	}


	@PostMapping
	public Category createCategory(@RequestBody final Category category) {
		return this.categoryService.createCategory(category);
	}


	@GetMapping("{id}")
	public Category getCategoryById(@PathVariable final long id) {
		return this.categoryService.getCategoryById(id);

	}

	@DeleteMapping("{id}")
	public String deleteCategory(@PathVariable final long id) {
		return this.categoryService.deleteCategory(id);

	}

	@PatchMapping("{id}")
	public Category updateCategory(@PathVariable final long id, @RequestBody final Category category) {
		return this.categoryService.updateCategory(id, category);
	}
}
