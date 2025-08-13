package com.springboot_test.stock_management.controller;

import com.springboot_test.stock_management.model.Produit;
import com.springboot_test.stock_management.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {
    @Autowired
    private final ProduitService produitService ;

    @GetMapping("/hello")
    public String sayHell(){
        return "Hello";
    }


    @GetMapping("/all")
    public List<Produit> getAllProduct(){
        return produitService.getAllProduit();

    }


    @PostMapping
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }
}
