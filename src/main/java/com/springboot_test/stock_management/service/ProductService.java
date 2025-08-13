package com.springboot_test.stock_management.service;

import com.springboot_test.stock_management.model.Product;
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
    private final ProductRepository productRepository ;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(long id) {

        Optional<Product> optionalproduct = productRepository.findById(id);
        if(optionalproduct.isEmpty()){
            throw new RuntimeException("Product Not Found ");
        }
        return optionalproduct.get();
    }

    public String deleteProduct(long id) {
        Optional<Product> optionalproduct = productRepository.findById(id);
        if(optionalproduct.isEmpty()){
            throw new RuntimeException("Product Not Found ");
        }
        productRepository.delete(optionalproduct.get());
        return "Product Deleted Successfully ";

    }

    public Product updateProduct(long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product Not Found");
        }

        Product updatedProduct = optionalProduct.get();

        if (product.getName() != null) {
            updatedProduct.setName(product.getName());
        }
        if (product.getPrice() != 0) {
            updatedProduct.setPrice(product.getPrice());
        }

        return productRepository.save(updatedProduct);
    }

}
