package com.springboot_test.stock_management.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long person_id;

	@NotBlank
	private String name;

	@Email
	private String email;

	@OneToMany(mappedBy = "person")
	private Set<Address> addresses;

	@OneToMany(mappedBy = "person")
	private Set<Order> orders;

	@OneToMany(mappedBy = "person")
	private Set<Profile> profiles;
}
