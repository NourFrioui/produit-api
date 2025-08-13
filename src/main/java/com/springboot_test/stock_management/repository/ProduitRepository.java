package com.springboot_test.stock_management.repository;

import com.springboot_test.stock_management.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
