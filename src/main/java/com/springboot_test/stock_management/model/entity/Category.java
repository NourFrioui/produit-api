package com.springboot_test.stock_management.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long category_id;
	private String name;

	@ManyToMany(mappedBy = "categories")
	private List<Product> products;

}
