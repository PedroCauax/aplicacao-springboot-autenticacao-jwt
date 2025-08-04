package com.springboot.Application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Application.exceptions.ProductNotFoundException;
import com.springboot.Application.models.Product;
import com.springboot.Application.repositories.ProductRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /* Product */
    public List<Product> listProduct() {
        return productRepository.findAll();
    }
    public Product getForId(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " +id+ " not found."));
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    public void deleteProduct(Long id) {
        if(!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with ID " +id+ " not found");
        }
        productRepository.deleteById(id);
    }
}
