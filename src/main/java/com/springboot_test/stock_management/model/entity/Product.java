package com.springboot_test.stock_management.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;

	private String name;

	private double price;

	@ManyToMany
	@JoinTable(
			name = "product_category",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private List<Category> categories;

	@OneToMany(mappedBy = "product")
	private Set<ProductDetail> productDetails;

	@OneToMany(mappedBy = "product")
	private Set<OrderItem> orderItems;
}
