package com.springboot_test.stock_management.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long profile_id;

	private String bio;

	private String profile_picture_url;

	@ManyToOne()
	@JoinColumn(name = "person_id")
	private Person person;
}
