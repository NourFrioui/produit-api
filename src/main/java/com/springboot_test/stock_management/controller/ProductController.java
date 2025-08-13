package com.springboot_test.stock_management.controller;

import com.springboot_test.stock_management.model.Product;
import com.springboot_test.stock_management.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService ;

    @GetMapping("/hello")
    public String sayHell(){
        return "Hello";
    }


    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();

    }


    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }


    @GetMapping("{id}")
    public Product getProductById(@PathVariable long id){
        return productService.getProductById(id);

    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);

    }


    @PatchMapping("{id}")
    public Product updateProduct(@PathVariable long id , @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

}
