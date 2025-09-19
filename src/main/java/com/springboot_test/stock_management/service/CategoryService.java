package com.springboot_test.stock_management.service;

import com.springboot_test.stock_management.model.entity.Category;
import com.springboot_test.stock_management.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
	@Autowired
	private final CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		return this.categoryRepository.findAll();
	}

	public Category createCategory(final Category category) {
		return this.categoryRepository.save(category);
	}

	public Category getCategoryById(final long id) {
		return this.categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found with id"));
	}

	public String deleteCategory(final long id) {
		if (!this.categoryRepository.existsById(id)) {
			throw new RuntimeException("Category not found with id " + id);
		}
		this.categoryRepository.deleteById(id);
		return "Category deleted successfully!";
	}

	public Category updateCategory(final long id, final Category updatedCategory) {
		return this.categoryRepository.findById(id)
				.map(category -> {
					category.setName(updatedCategory.getName());
					return this.categoryRepository.save(category);
				})
				.orElseThrow(() -> new RuntimeException("Category not found with id " + id));
	}
}
