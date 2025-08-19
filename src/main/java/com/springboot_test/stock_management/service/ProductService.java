package com.springboot_test.stock_management.service;

import com.springboot_test.stock_management.exceptions.NotFoundException;
import com.springboot_test.stock_management.model.dto.ProductDto;
import com.springboot_test.stock_management.model.entity.Category;
import com.springboot_test.stock_management.model.entity.Product;
import com.springboot_test.stock_management.repository.CategoryRepository;
import com.springboot_test.stock_management.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
	@Autowired
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;


	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}

	public Product createProduct(final ProductDto request) {
		final List<Long> categoryIds = request.getCategoryIds();
		final List<Category> categories = this.categoryRepository.findAllById(categoryIds);

		if (categories.isEmpty()) {
			throw new NotFoundException("No valid categories found for this product");
		}

		final Product product = new Product();
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product.setCategories(categories);

		return this.productRepository.save(product);
	}


	public Product getProductById(final long id) {
		return this.productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Product not found with id " + id));
	}

	public String deleteProduct(final long id) {
		final Optional<Product> optionalProduct = this.productRepository.findById(id);
		if (optionalProduct.isEmpty()) {
			throw new NotFoundException("Product Not Found ");
		}
		this.productRepository.delete(optionalProduct.get());
		return "Product Deleted Successfully ";

	}

	public Product updateProduct(final long id, final Product product) {
		final Optional<Product> optionalProduct = this.productRepository.findById(id);
		if (optionalProduct.isEmpty()) {
			throw new NotFoundException("Product Not Found");
		}

		final Product updatedProduct = optionalProduct.get();

		if (product.getName() != null) {
			updatedProduct.setName(product.getName());
		}
		if (product.getPrice() != 0) {
			updatedProduct.setPrice(product.getPrice());
		}

		return this.productRepository.save(updatedProduct);
	}

}
