package com.springboot_test.stock_management.service;

import com.springboot_test.stock_management.model.Produit;
import com.springboot_test.stock_management.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitService {
    @Autowired
    private final ProduitRepository produitRepository ;

    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }
}
